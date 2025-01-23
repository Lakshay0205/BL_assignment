import java.util.*;
public class marks{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter marks of physics: ");
         int physics = sc.nextInt();
         System.out.println("Enter marks of chemistry: ");
         int chemistry = sc.nextInt();
         System.out.println("Enter marks of maths: ");
         int maths = sc.nextInt();
         int total = physics + chemistry + maths;
         double percentage = (total / 300) * 100;
         String grade = "";
         if (percentage >= 80) {
            grade = "A";
            }
            else if (percentage >= 70 && percentage < 80) {
                grade = "B";
                }
                else if (percentage >= 60 && percentage < 70) {
                    grade = "C";    
                    }
                    else if (percentage >= 50 && percentage < 60) {
                        grade = "D";
                        }
                        else if (percentage >= 40 && percentage < 50) {
                            grade = "E";
                            }
                            else {
                                grade = "R";
                                }
                                System.out.println("Your grade is: " + grade);
                                }
         
    }