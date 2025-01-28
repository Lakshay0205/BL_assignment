import java.util.Scanner;

public class FriendsStats {
    public static int findYoungest(int[] ages) {
        int youngest = Integer.MAX_VALUE;
        for (int age : ages) {
            if (age < youngest)
                youngest = age;
        }
        return youngest;
    }

    public static int findTallest(int[] heights) {
        int tallest = Integer.MIN_VALUE;
        for (int height : heights) {
            if (height > tallest)
                tallest = height;
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of friend " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter the height (in cm) of friend " + (i + 1) + ": ");
            heights[i] = sc.nextInt();
        }

        System.out.println("Youngest friend's age: " + findYoungest(ages));
        System.out.println("Tallest friend's height: " + findTallest(heights) + " cm");
    }
}
