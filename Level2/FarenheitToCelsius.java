package Level2;

import java.util.*;
public class FarenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input farenheit
        double farenheit = sc.nextInt();

        // calculate celsius

        double celsius = (farenheit - 32)* 5/9;

        System.out.print("Celsius: "+celsius);
    }
}
