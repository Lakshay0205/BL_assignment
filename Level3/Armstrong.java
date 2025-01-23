package Level3;

import java.lang.Math;
import java.util.*;
public class Armstrong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int temp = n;
        int digit = 0;
        while(temp != 0) {
            digit = temp % 10;
            sum = sum + (int)Math.pow(digit, 3);
            temp = temp / 10;
    }
    if(n == sum) {
        System.out.println(n + " is an Armstrong number");
    }
    else {
        System.out.println(n + " is not an Armstrong number");
    }
}

}