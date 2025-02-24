package Reflection.AdvancedPrograms;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    String sayHello(String name);
    int calculate(int a, int b);
}

class GreetingImpl implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class LoggingProxy {

    public static void main(String[] args) {
        Greeting realGreeting = new GreetingImpl();
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(realGreeting)
        );

        String greeting = proxyGreeting.sayHello("World");
        System.out.println(greeting);

        int result = proxyGreeting.calculate(5, 10);
        System.out.println("Result: " + result);

    }
}