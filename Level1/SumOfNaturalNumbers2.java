import java.util.*;
public class SumOfNaturalNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;
        for(int i = 1; i <= n; i++){
            sum2 = sum2 + i;
        }

        if(sum1 == sum2)
        System.out.println("Both methods produce the same result");
        else
        System.out.println("Both methods do not produce the same result");
    }
}
