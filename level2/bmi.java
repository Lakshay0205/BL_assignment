import java.util.*;
public class bmi {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight in kg: ");
        double weight = sc.nextDouble();
        System.out.println("Enter your height in cm: ");
        double height = sc.nextDouble();
        double bmi = weight / (height * height / 10000);
        if (bmi < 18.5) {
            System.out.println("Your weight status is underweight");
            } else if (bmi < 25) {
                System.out.println("Your weight status is normal");
                } else if (bmi < 30) {
                    System.out.println("Your weight status is overweight");
                    } else {
                        System.out.println("Your weight status is obese");
                        }
                        }
}