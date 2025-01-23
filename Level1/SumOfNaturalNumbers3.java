import java.util.*;
public class SumOfNaturalNumbers3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;
        int i = 1;
        while( i <= n){
            sum2 = sum2 + i;
            i++;
        }

        if(sum1 == sum2)
        System.out.println("Both methods produce the same result");
        else
        System.out.println("Both methods do not produce the same result");
    }
}
