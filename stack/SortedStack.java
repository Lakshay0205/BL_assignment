package stack;

import java.util.Stack;
public class SortedStack {
    public void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
        }
    }
        public void insertSorted(Stack<Integer> stack, int top) {
            if(stack.isEmpty() || stack.peek() <= top) {
                stack.push(top);
                return;
            }
            else {
                int temp = stack.pop();
                insertSorted(stack, top);
                stack.push(temp);
            }
        }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(38);

        SortedStack obj = new SortedStack();

        System.out.println("Stack before sorting: " + stack);

        obj.sortStack(stack);

        System.out.println("Stack after sorting: " + stack);
    }
}
