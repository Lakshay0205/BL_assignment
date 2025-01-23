import java.util.*;
public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        if(n <= 1){
            System.out.println("Number is not valid");
        }
        int GreatestFactor = 0;
        for(int i = 2; i<=n; i++ ){
            if(n % i == 0){
                GreatestFactor = i;
        }
        System.out.println("Greatest factor of " + n + " is " + GreatestFactor);
        }
    }
}