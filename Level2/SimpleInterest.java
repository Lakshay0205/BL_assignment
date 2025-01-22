package Level2;
import java.util.*;
public class SimpleInterest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Take principal, rate and time as input: "); 
        double principal = sc.nextDouble();
        double rate = sc.nextDouble(); 
        double time = sc.nextDouble();

        // calculate simple interest
        double SI = (principal*rate*time)/100;
        System.out.print("Simple interest: "+SI);
    }
}
