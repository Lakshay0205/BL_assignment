package QueueInterface;

import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size, head, tail, count;
    
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    
    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;
        if (count < size) {
            count++;
        } else {
            head = (head + 1) % size;
        }
    }
    
    public List<Integer> getBufferContents() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(buffer[(head + i) % size]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        System.out.println("Buffer: " + cb.getBufferContents());
        
        cb.add(4); // Overwrites oldest element
        System.out.println("Buffer after adding 4: " + cb.getBufferContents());
    }
}
