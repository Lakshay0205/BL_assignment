class Task {
    int taskId, priority;
    String taskName, dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;

    public TaskScheduler() {
        this.head = null;
    }

    // Add a task at the end
    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;

        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    if (temp == head) {
                        Task last = head;
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

    // View the current task and move to the next task
    public void viewCurrentAndNext() {
        if (head == null) return;
        System.out.println("Current Task: " + head.taskName + " (Priority: " + head.priority + ")");
        head = head.next;
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.taskId + ". " + temp.taskName + " - Priority: " + temp.priority + " - Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by priority
    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + " - Due: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Complete Project", 1, "2025-02-15");
        scheduler.addTask(2, "Submit Report", 2, "2025-02-18");
        scheduler.addTask(3, "Prepare Presentation", 3, "2025-02-20");

        System.out.println("Task List:");
        scheduler.displayTasks();
        
        System.out.println("\nViewing Current Task and Moving to Next:");
        scheduler.viewCurrentAndNext();
        scheduler.viewCurrentAndNext();
        
        System.out.println("\nSearching for Tasks with Priority 2:");
        scheduler.searchByPriority(2);
        
        System.out.println("\nRemoving Task ID 2 and Displaying Remaining Tasks:");
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}
