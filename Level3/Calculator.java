package Level3;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0); 

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double res = 0;

        switch (op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                    return; 
                }
                res = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator!");
                break; 
        }

        System.out.println("Result: " + res);
    }
}
