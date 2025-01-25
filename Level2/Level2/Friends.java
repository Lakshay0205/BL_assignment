import java.util.Scanner;
class Friends {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		// creating arrays

		String [] name = {"Amar","Akabhar","Anthony"};
		int [] ages = new int [3];
		double height [] = new double [3];

		for(int i = 0; i < 3; i++) {
			System.out.print("Enter the age: ");
			ages[i] = sc.nextInt();
			System.out.print("Enter the height: ");
			height[i] = sc.nextDouble();
		}
		int ageindex = 0;
		int heightindex = 0;

		for(int i = 1; i < ages.length; i++) {
			if(ages[i] < ages[ageindex])
				ageindex ++;
		}

		for(int i = 1; i < height.length; i++) {
			if(height[i] > height[heightindex])
				heightindex ++;
		}

		System.out.print("The youngest friend " + name[ageindex] +" of age " + ages[ageindex]);
		System.out.print("The tallest friend " + name[heightindex] + " of height " + height[heightindex]);
	}
} 
