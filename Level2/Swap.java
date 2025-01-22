package Level2;

public class Swap {
    public static void main(String [] args){
        // Take two numbers as input
        int num1 = 10;
        int num2 = 5;
        System.out.println("Before swapping: "+ num1 + "and" + num2);

        // Swapping two numbers
        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.print("After swapping two numbers:"+ num1 + "and"+ num2);
    }
}
