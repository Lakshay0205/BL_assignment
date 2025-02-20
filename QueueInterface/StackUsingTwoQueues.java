package QueueInterface;

import java.util.Queue;
import java.util.LinkedList;

public class StackUsingTwoQueues<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void push(T data) {
        while(!isEmpty()) {
            q2.add(q1.remove());
        }
        q1.add(data);
        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    public T pop() {
        return q1.remove();
    }

    public T peek() {
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues<String> stringStack = new StackUsingTwoQueues<>();
        stringStack.push("Hello");
        stringStack.push("World");

        while(!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());

        }
    }
}