package JUnit.BasicProblems;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {

    public String longRunningTask() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task completed";
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTask() {
        longRunningTask();
    }
}