package QueueInterface;

import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        // Comparator for severity (higher severity gets higher priority)
        Comparator<Patient> severityComparator = Comparator.comparingInt(p -> -p.severity);

        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(severityComparator);

        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));
        triageQueue.offer(new Patient("Eve", 4));
        triageQueue.offer(new Patient("Grace", 1));


        System.out.println("Triage Order:");
        while (!triageQueue.isEmpty()) {
            Patient patient = triageQueue.poll();
            System.out.println(patient);
        }

    }
}