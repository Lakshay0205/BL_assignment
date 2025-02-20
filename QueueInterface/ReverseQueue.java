package QueueInterface;

import java.util.*;

public class ReverseQueue {
    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        return queue;
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        
        System.out.println("Original Queue: " + queue);
        queue = reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
