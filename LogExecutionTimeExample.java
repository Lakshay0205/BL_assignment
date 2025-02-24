import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

interface MyService {
    void performTask1();
    void performTask2();
}

class MyServiceImpl implements MyService {

    @LogExecutionTime
    public void performTask1() {
        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 1 performed.");
    }

    @LogExecutionTime
    public void performTask2() {
        try {
            Thread.sleep(500); // Simulate more work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 2 performed.");
    }
}

class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            Object result = method.invoke(target, args);
            long endTime = System.nanoTime();
            System.out.println("Method '" + method.getName() + "' execution time: " + (endTime - startTime) + " nanoseconds");
            return result;
        } else {
            return method.invoke(target, args);
        }
    }
}

public class LogExecutionTimeExample {

    public static void main(String[] args) {
        MyService realService = new MyServiceImpl();

        MyService proxyService = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),
                new Class[]{MyService.class},
                new LoggingInvocationHandler(realService)
        );

        proxyService.performTask1();
        proxyService.performTask2();
    }
}