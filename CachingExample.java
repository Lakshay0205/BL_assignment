import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

interface ComputationService {
    @CacheResult
    int computeExpensiveResult(int input);
}

class ComputationServiceImpl implements ComputationService {

    @Override
    public int computeExpensiveResult(int input) {
        try {
            Thread.sleep(1000); // Simulate expensive computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * input; // Example computation
    }
}

class CachingInvocationHandler implements InvocationHandler {

    private final Object target;
    private final Map<Object, Object> cache = new HashMap<>();

    public CachingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            Object key = args[0]; // Assuming single argument for simplicity
            if (cache.containsKey(key)) {
                System.out.println("Retrieving from cache...");
                return cache.get(key);
            } else {
                Object result = method.invoke(target, args);
                cache.put(key, result);
                System.out.println("Computing and caching...");
                return result;
            }
        } else {
            return method.invoke(target, args);
        }
    }
}

public class CachingExample {

    public static void main(String[] args) {
        ComputationService realService = new ComputationServiceImpl();

        ComputationService proxyService = (ComputationService) Proxy.newProxyInstance(
                ComputationService.class.getClassLoader(),
                new Class[]{ComputationService.class},
                new CachingInvocationHandler(realService)
        );

        System.out.println(proxyService.computeExpensiveResult(5));
        System.out.println(proxyService.computeExpensiveResult(5)); // Should retrieve from cache
        System.out.println(proxyService.computeExpensiveResult(10));
        System.out.println(proxyService.computeExpensiveResult(10)); // Should retrieve from cache
    }
}