import java.io.*;

public class UserDataToFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter("user_data.txt");

            System.out.print("Enter your name: ");
            String name = reader.readLine();
            writer.write("Name: " + name + "\n");

            System.out.print("Enter your age: ");
            String age = reader.readLine();
            writer.write("Age: " + age + "\n");

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            writer.write("Favorite Language: " + language + "\n");

            reader.close();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}