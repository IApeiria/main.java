package com.tnwb.lesson12.completableFutures;

import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.imageio.*;

public class CompletableFutureDemo
{
   private static final Pattern IMG_PATTERN = Pattern.compile(
      "[<]\\s*[iI][mM][gG]\\s*[^>]*[sS][rR][cC]\\s*[=]\\s*['\"]([^'\"]*)['\"][^>]*[>]");
   private ExecutorService executor = Executors.newCachedThreadPool();
   private URL urlToProcess;

   public CompletableFuture<String> readPage(URL url)
   {
      return CompletableFuture.supplyAsync(() -> 
         {
            try
            {
               String contents = new String(Files.readAllBytes(Paths.get(String.valueOf(url))),
                  StandardCharsets.UTF_8);
               System.out.println("Read page from " + url);
               return contents;
            }
            catch (IOException e)
            {
               throw new UncheckedIOException(e);
            }
         }, executor);
   }

   public List<URL> getImageURLs(String webpage) // not time-consuming
   { 
      try
      {
         ArrayList result = new ArrayList<URL>();
         Matcher matcher = IMG_PATTERN.matcher(webpage);
         while (matcher.find())
         {
            URL url = new URL(urlToProcess, matcher.group(1));
            result.add(url);
         }
         System.out.println("Found URLs: " + result);
         return result;
      }
      catch (IOException e)
      {
         throw new UncheckedIOException(e);
      }
   }

   public CompletableFuture<List<BufferedImage>> getImages(List<URL> urls)
   {
      return CompletableFuture.supplyAsync(() -> 
         {
            try
            {
               ArrayList<BufferedImage> result = new ArrayList<>();
               for (URL url : urls)
               {
                  result.add(ImageIO.read(url));
                  System.out.println("Loaded " + url);
               }
               return result;
            }
            catch (IOException e)
            {
               throw new UncheckedIOException(e);
            }
         }, executor);
   }

   public void saveImages(List<BufferedImage> images)
   {
      System.out.println("Saving " + images.size() + " images");
      try
      {
         for (int i = 0; i < images.size(); i++)
         {
            String filename = "/tmp/image" + (i + 1) + ".png";
            ImageIO.write(images.get(i), "PNG", new File(filename));
         }
      }
      catch (IOException e)
      {
         throw new UncheckedIOException(e);
      }
      executor.shutdown();
   }

   public void run(URL url)
         throws IOException, InterruptedException
   {
      urlToProcess = url;
      CompletableFuture.completedFuture(url)
         .thenComposeAsync(this::readPage, executor)
         .thenApply(this::getImageURLs) 
         .thenCompose(this::getImages)
         .thenAccept(this::saveImages); 
         
      /* 
      // or use the experimental HTTP client:
       
      HttpClient client = HttpClient.newBuilder().executor(executor).build();
      HttpRequest request = HttpRequest.newBuilder(urlToProcess.toURI()).GET()
         .build();
      client.sendAsync(request, BodyProcessor.asString())
         .thenApply(HttpResponse::body).thenApply(this::getImageURLs)
         .thenCompose(this::getImages).thenAccept(this::saveImages);
      */
   }

   public static void main(String[] args) 
         throws IOException, InterruptedException
   {
      new CompletableFutureDemo().run(new URL("http://horstmann.com/index.html"));
   }
}
