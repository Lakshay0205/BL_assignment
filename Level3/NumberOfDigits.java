package Level3;

import java.util.*;
public class NumberOfDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count_digits = 0;

        while (num != 0) {
            num /= 10;
            count_digits++;
        }
        System.out.println(count_digits);
    }
}
