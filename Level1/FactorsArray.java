import java.util.*;
public class FactorsArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number:");
		int number = sc.nextInt();
		int maxfactor = 10;
		int [] factor = new int [maxfactor];
		int index = 0;
		for(int i = 0; i <= number; i++) {
			if(number % i == 0) {

				if(index == maxfactor) {
					maxfactor *= 2;
					int [] temp = new int [maxfactor];
					System.arraycopy(factor, 0, temp, 0, factor.length);
					factor = temp;
				}
				factor[index++] = i;
			}
		}

		for(int i = 0; i < index; i++) {
			System.out.print(factor[i] + " ");
		}
	}
}		
		
