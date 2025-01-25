import java.util.Scanner;
class Salary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double [] old_salary = new double [10];
		// year of experience of employees
		double [] year_experience = new double [10];

		double [] new_salary = new double [10];
		double total_bonus = 0.0;
		for(int i = 0; i < 10; i++) {
			if(year_experience[i] >= 5) {
				total_bonus = old_salary[i] * 0.05 + total_bonus;
				new_salary[i] = old_salary[i] * 0.05 + old_salary[i];
			}
			else {
				total_bonus = old_salary[i] * 0.02 + total_bonus;
				new_salary[i] = old_salary[i] * 0.02 + old_salary[i];
			}
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.print("New Salary of the employees: "+ new_salary[i] + " ");
		}
		System.out.print("Total Bonus payout by the company: " + total_bonus);
	}
}
