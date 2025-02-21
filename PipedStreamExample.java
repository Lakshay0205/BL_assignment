import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) throws IOException {
        PipedOutputStream pout = new PipedOutputStream();
        PipedInputStream pin = new PipedInputStream(pout);

        Thread writerThread = new Thread(() -> {
            try {
                String message = "Hello from writer thread!";
                pout.write(message.getBytes());
                pout.close(); // Important: Close the output stream to signal end of data
                System.out.println("Writer thread finished.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            try {
                int data;
                StringBuilder message = new StringBuilder();
                while ((data = pin.read()) != -1) {
                    message.append((char) data);
                }
                System.out.println("Reader thread received: " + message);
                pin.close();
                System.out.println("Reader thread finished.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writerThread.start();
        readerThread.start();


        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");

    }
}