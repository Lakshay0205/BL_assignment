import java.io.*;

public class BufferedFileCopy {

    public static void main(String[] args) throws IOException {
        String sourceFile = "source.txt";
        String destinationFileBuffered = "destination_buffered.txt";
        String destinationFileUnbuffered = "destination_unbuffered.txt";

        long startTime, endTime;

        // Buffered Copy
        startTime = System.nanoTime();
        copyFileBuffered(sourceFile, destinationFileBuffered);
        endTime = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTime - startTime) + " ns");


        // Unbuffered Copy
        startTime = System.nanoTime();
        copyFileUnbuffered(sourceFile, destinationFileUnbuffered);
        endTime = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endTime - startTime) + " ns");

    }

    static void copyFileBuffered(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(destination);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    static void copyFileUnbuffered(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        }
    }
}