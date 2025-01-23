package Level1;

import java.util.Scanner;
public class RocketLaunch2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the countdown starting number: ");
        int counter = sc.nextInt();

        for (;counter > 0; counter--) {
            System.out.println(counter); 
        }

        System.out.println("Blast Off!");

        sc.close();
    }
}