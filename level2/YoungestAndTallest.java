import java.util.*;
public class YoungestAndTallest {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // name of friends
        String friend1 = "Amar", friend2 = "Akbar", friend3 = "Anthony";
        // age and height of friends
        System.out.print("Enter the age and height of: "+friend1);
        int age1 = sc.nextInt();
        double height1 = sc.nextDouble();

        System.out.print("Enter the age and height of: "+friend2);
        int age2 = sc.nextInt();
        double height2 = sc.nextDouble();

        System.out.print("Enter the age and height of: "+friend3);
        int age3 = sc.nextInt();
        double height3 = sc.nextDouble();

        // for smallest age among the friends
        if (age1 <= age2 && age1 <= age3)
        System.out.println( friend1 + " is the smallest");
 
        else if (age2 <= age1 && age2 <= age3)
        System.out.println( friend2 + " is the smallest");
 
        else
        System.out.println( friend3 + " is the smallest");

        // for tallest height among the friends
        if (height1 >= height2 && height1 >= height3)
        System.out.println( friend1 + " is the tallest");
 
    else if (height2 >= height1 && height2 >= height3)
        System.out.println( friend2 + " is the tallest");
 
    else
        System.out.println( friend3 + " is the tallest");
    }
}
