import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskProcessor {

    @ImportantMethod
    public void processCriticalData() {
        System.out.println("Processing critical data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void processRegularData() {
        System.out.println("Processing regular data...");
    }

    public void processOptionalData() {
        System.out.println("Processing optional data...");
    }
}

public class ImportantMethodAnnotationExample {

    public static void main(String[] args) {
        try {
            Class<?> taskProcessorClass = TaskProcessor.class;
            Method[] methods = taskProcessorClass.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: " + method.getName() + ", Level: " + importantMethod.level());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}