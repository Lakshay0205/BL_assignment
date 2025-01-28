import java.util.Random;

public class EmployeeBonus {

    // Method to generate salary and years of service for each employee
    public static double[][] generateEmployeeData() {
        Random rand = new Random();
        double[][] employeeData = new double[10][2]; // 10 employees, 2 columns (salary, years of service)

        for (int i = 0; i < 10; i++) {
            // Generate random salary between 30000 and 99999 (5-digit salary)
            employeeData[i][0] = 30000 + rand.nextInt(70000);
            // Generate random years of service between 1 and 15 years
            employeeData[i][1] = 1 + rand.nextInt(15);
        }

        return employeeData;
    }

    // Method to calculate new salary and bonus based on years of service
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[10][3]; // 10 employees, 3 columns (old salary, new salary, bonus)

        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            int yearsOfService = (int) employeeData[i][1];
            double bonus;

            // Determine bonus based on years of service
            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05; // 5% bonus for employees with more than 5 years of service
            } else {
                bonus = oldSalary * 0.02; // 2% bonus for employees with less than 5 years of service
            }

            // Calculate the new salary
            double newSalary = oldSalary + bonus;

            // Store the data: old salary, new salary, and bonus
            updatedData[i][0] = oldSalary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }

        return updatedData;
    }

    // Method to calculate and display the sum of old salary, new salary, and total
    // bonus amount
    public static void calculateAndDisplayTotals(double[][] updatedData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        // Calculate the total old salary, new salary, and total bonus
        for (int i = 0; i < 10; i++) {
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
        }

        // Display the data in tabular format
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Employee", "Old Salary", "New Salary", "Bonus");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f\n", i + 1, updatedData[i][0], updatedData[i][1],
                    updatedData[i][2]);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus Amount: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        // Generate random data for employees (salary and years of service)
        double[][] employeeData = generateEmployeeData();

        // Calculate new salary and bonus for each employee
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);

        // Display the results
        calculateAndDisplayTotals(updatedData);
    }
}
