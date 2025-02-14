import java.util.*;
public class Bubble{
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] marks= new int[n];
	for(int i =0;i<n;i++){
	marks[i]=sc.nextInt();
}
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
        
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}

