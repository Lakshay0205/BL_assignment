package Level3;

import java.util.*;
public class HarshadNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int originalnumber = sc.nextInt();
        int sumOfdigits = 0;
        int temp = originalnumber;
        while(temp != 0){
            int singleDigit = temp % 10;
            sumOfdigits = sumOfdigits + singleDigit;
            temp = temp / 10;
        }

        if(originalnumber % sumOfdigits == 0){
            System.out.println(originalnumber + " is a Harshad Number");
        }
        else{
            System.out.println(originalnumber + " is not a Harshad Number");
        }
    }
}