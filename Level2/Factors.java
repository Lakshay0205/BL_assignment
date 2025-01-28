import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Factors {
	public static int[] factor(int number) {
		int count = 0;
		for(int i = 1; i <= number; i++) {
			if(number % i == 0)
				count++;
		}
		
		int [] factor = new int [count];
		
		for(int i = 0; i < count; i++) {
			if(number % i+1 == 0) {
				factor[i] = i+1;
			}
		}
		
		return factor;
	}
	
	public static int sumFactor(int [] factor) {
		int sum = 0;
		for(int i = 0; i < factor.length; i++ ) {
			sum += factor[i];
		}
		
		return sum;
	}
	
	public static int product(int [] factor) {
		int product = 1;
		for(int i = 0; i < factor.length; i++ ) {
			product *= factor[i];
		}
		
		return product;
	}
	
	public static int  powFactor(int [] factor) {
		int [] powfactor = new int [factor.length];
		for(int i = 0; i < powfactor.length; i++) {
			powfactor[i] = (int) Math.pow(factor[i], 2);
		}

        int sumOfSquares = 0;
        for(int i = 0; i < powfactor.length; i++ ) {
            sumOfSquares += powfactor[i];
        }
		
		return sumOfSquares;
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		Factors obj = new Factors();
		
		int [] factor = obj.factor(number);
		
		int sum = obj.sumFactor(factor);
		int product = obj.product(factor);
		int sumOfSquares = obj.powFactor(factor);
        
         // Display the results
        System.out.println("Factors: " + Arrays.toString(factor));
        System.out.println("Sum of Factors: " + sum);
        System.out.println("Product of Factors: " + product);
        System.out.println("Sum of Squares of Factors: " + sumOfSquares);

    }
}