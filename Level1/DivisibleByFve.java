import java.util.*;
public class DivisibleByFve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 5 == 0){
            System.out.println("The number is divisible by 5");
        }
        else{
            System.out.println("The number is not divisible by 5");
        }
    }
}
