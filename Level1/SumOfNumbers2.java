import java.util.Scanner;
public class SumOfNumbers2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int number;

        System.out.println("Enter numbers (enter 0 to stop):");

        while (true) {
            number = sc.nextInt();
            if(number <= 0){
                break;
            }
            total += number;
        }

        System.out.println("Sum of entered numbers: " + total);

        sc.close();
    }
}