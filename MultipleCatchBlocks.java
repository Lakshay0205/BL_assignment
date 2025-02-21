import java.util.Scanner;

public class MultipleCatchBlocks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            System.out.println("Enter the array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }


            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();

            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}