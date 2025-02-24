import java.lang.annotation.*;
import java.lang.reflect.*;

// Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Sample class using the @Todo annotation
class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        // Implementation pending
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        // Implementation pending
    }

    @Todo(task = "Add logging to payment module", assignedTo = "Charlie", priority = "LOW")
    public void paymentLogging() {
        // Implementation pending
    }
}

// Reflection to retrieve and print @Todo annotations
public class TodoProcessor {
    public static void main(String[] args) {
        Class<Project> obj = Project.class;
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("----------------------------");
            }
        }
    }
}
