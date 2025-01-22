import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the unit price of an item: ");
        double unitPrice = scanner.nextDouble();
        System.out.println("Enter the quantity to be bought: ");
        int quantity = scanner.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.println("The total price is: " + totalPrice);
        }
        }