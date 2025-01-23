import java.util.*;
public class SumOfNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num >= 1){
            int sum = num * (num + 1) / 2;
            System.out.print(num + "is natural  and the sum of natural number is: " + sum);
        }
        else 
        System.out.println("The number is not natural number");
    }
}
