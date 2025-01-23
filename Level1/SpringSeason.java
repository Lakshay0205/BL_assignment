import java.util.*;
public class SpringSeason{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int month = sc.nextInt();

        if(day >= 20 && month >= 3 || month <= 6){
            System.out.println("It is a spring season");
        }
        else
        System.out.println("It is not a spring season");
    }
}