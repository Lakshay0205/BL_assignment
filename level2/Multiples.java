import java.util.Scanner;
public class Multiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.print("Multiples of " + number + " below 100:");

        for (int i = 1; i < 100; i++) {
            if (i % number == 0) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }
}