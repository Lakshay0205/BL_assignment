package Level3;

import java.util.*;
public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int sumOfdivisors = 0;

        for(int i = 1; i < num; i++){
            if(num % i == 0){
                sumOfdivisors += i;
            }
        }
        if(sumOfdivisors > num){
            System.out.println(num + " is an abundant number");
        }
        else{
            System.out.println(num + " is not an abundant number");
        }
    }
}
