package Level2;

import java.util.*;
public class TemperatureConversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // input celsius
        double celsius = sc.nextInt();
        // calculate farenheit
        double farenheit = ((celsius * 9)/5)+32;

        System.out.print("Farenheit: "+farenheit);
    }
}
