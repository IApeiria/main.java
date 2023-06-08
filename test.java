import java.io.*;
public class test {
        public static void main(String[] args) throws IOException {
            byte[] data;
            try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                output.write("Hello ".getBytes("UTF-8"));
                output.write("world!".getBytes("UTF-8"));
                data = output.toByteArray();
            }
            //add a comment
            System.out.println(new String(data));
        }
    }

