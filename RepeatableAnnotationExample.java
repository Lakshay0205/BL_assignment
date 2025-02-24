import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {

    @BugReport(description = "NullPointerException in calculation.")
    @BugReport(description = "Incorrect result for negative input.")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class RepeatableAnnotationExample {

    public static void main(String[] args) {
        try {
            Class<?> bugTrackerClass = BugTracker.class;
            Method processDataMethod = bugTrackerClass.getMethod("processData");

            if (processDataMethod.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = processDataMethod.getAnnotation(BugReports.class);
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Report: " + bugReport.description());
                }
            } else if (processDataMethod.isAnnotationPresent(BugReport.class)){
                BugReport bugReport = processDataMethod.getAnnotation(BugReport.class);
                System.out.println("Bug Report: " + bugReport.description());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}