package Level2;

import java.util.*;
public class PoundToKilogramConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the weight in pounds: ");
        double weightInPounds = scanner.nextDouble();
        double weightInKilograms = weightInPounds / 2.2;
        System.out.print("The weight of the person in pound is "+ weightInPounds+ "and in kg is "+weightInKilograms);
    }
}
