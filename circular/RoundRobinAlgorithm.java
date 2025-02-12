class Process {
    int processId, burstTime, priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    if (temp == head) {
                        Process last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate Round Robin Scheduling
    public void simulateScheduling() {
        if (head == null) return;
        Process temp = head;
        System.out.println("Executing Round Robin Scheduling:");
        do {
            if (temp.burstTime > 0) {
                int executedTime = Math.min(timeQuantum, temp.burstTime);
                System.out.println("Process " + temp.processId + " executed for " + executedTime + " units.");
                temp.burstTime -= executedTime;
                if (temp.burstTime == 0) {
                    System.out.println("Process " + temp.processId + " completed.");
                    removeProcess(temp.processId);
                }
            }
            temp = temp.next;
        } while (temp != head);
    }

    // Display all processes
    public void displayProcesses() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println("Process " + temp.processId + " - Burst Time: " + temp.burstTime + " - Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Initial Process List:");
        scheduler.displayProcesses();
        
        System.out.println("\nSimulating Round Robin Scheduling:");
        scheduler.simulateScheduling();
    }
}
