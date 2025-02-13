package stack;

import java.util.Arrays;
import java.util.Stack;
public class StockSpan {

    public static int [] calculateSpan(int[] price) {
        Stack <Integer> stack = new Stack<>();
        int [] span = new int[price.length];

        for(int i = 0; i < price.length; i++) {
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            //calculate span
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int [] price = {100, 80, 60, 70, 60, 75, 85};
        int [] span = calculateSpan(price);
        System.out.println("price: " + Arrays.toString(price));
        System.out.println("span: " + Arrays.toString(span));
    }
}
