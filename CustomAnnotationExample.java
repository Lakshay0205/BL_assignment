import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority() default "Medium";
    String assignedTo() default "Unassigned";
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void performTask() {
        System.out.println("Performing task...");
    }

    @TaskInfo
    public void defaultTask(){
        System.out.println("Performing default task");
    }
}

public class CustomAnnotationExample {

    public static void main(String[] args) {
        try {
            Class<?> taskManagerClass = TaskManager.class;
            Method performTaskMethod = taskManagerClass.getMethod("performTask");
            Method defaultTaskMethod = taskManagerClass.getMethod("defaultTask");

            if (performTaskMethod.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = performTaskMethod.getAnnotation(TaskInfo.class);
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            if (defaultTaskMethod.isAnnotationPresent(TaskInfo.class)){
                TaskInfo taskInfo2 = defaultTaskMethod.getAnnotation(TaskInfo.class);
                System.out.println("Default Task Priority: " + taskInfo2.priority());
                System.out.println("Default Assigned To: " + taskInfo2.assignedTo());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}