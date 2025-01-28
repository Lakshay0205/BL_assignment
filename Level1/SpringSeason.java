import java.util.Scanner;

public class SpringSeason {

    
    public static boolean isSpringSeason(int month, int day) {
        // Check for March
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        }
        // Check for April
        else if (month == 4 && day >= 1 && day <= 30) {
            return true;
        }
        // Check for May
        else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        }
        // Check for June
        else if (month == 6 && day >= 1 && day <= 20) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the month (1-12):");
        int month = sc.nextInt();

        System.out.println("Enter the day (1-31):");
        int day = sc.nextInt();

        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season.");
        } 
		else {
            System.out.println("Not a Spring Season.");
        }
    }
}
