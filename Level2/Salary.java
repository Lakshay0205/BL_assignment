package Level2;

import java.util.*;
public class Salary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Enter the salary of individual
        int salary = sc.nextInt();
        // Enter the bonus of individual
        int bonus = sc.nextInt();
        // Calculate the total salary of individual
        int totalSalary = salary + bonus;
        System.out.println("Total Salary of Individual is: " + totalSalary);
    
    }
}
