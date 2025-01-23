import java.util.*;
public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        if(n <= 1){
            System.out.println("Number is invalid.");
        }
        System.out.print("Factors of number"+ n +"is: ");
        for(int i = 2; i <= n; i++){
            if(n%i == 0){
                System.out.println(i);
            }
        }
    }
}