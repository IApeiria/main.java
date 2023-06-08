package com.tnwb.lesson9.set;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class SetTest
{
   public static void main(String[] args)
   {
      Set<String> words = new HashSet<>();
      long totalTime = 0;

      try (Scanner in = new Scanner(Paths.get("D:\\javacode\\corejava\\out\\production\\corejava\\com\\tnwb\\lesson9\\set\\alice30.txt"), "UTF-8"))
      {
         while (in.hasNext())
         {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      Iterator<String> iter = words.iterator();
      for (int i = 1; i <= 20 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
   }
}
