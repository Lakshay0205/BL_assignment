import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageToByteArray {

    public static void main(String[] args) {
        String imagePath = "input.jpg"; // Replace with your image file
        String newImagePath = "output.jpg";

        try {
            // Read image into byte array
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

            // Write byte array to new image file
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File(newImagePath)); // Change "jpg" if needed

            System.out.println("Image converted and saved to " + newImagePath);


            //Verification (Optional -  Compares file sizes as a basic check.  For more robust verification, you might compare pixel data).
            long originalFileSize = new File(imagePath).length();
            long newFileSize = new File(newImagePath).length();

            if (originalFileSize == newFileSize) {
                System.out.println("File size verification passed.");
            } else {
                System.out.println("File size verification failed. Files are different.");
            }



        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}