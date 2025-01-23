import java.util.*;
public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int factorial = 1;
        for (; num != 0; num--) {
            factorial *= num;
        }
        System.out.println("Factorial of " + num + " is " + factorial);
    }
}
