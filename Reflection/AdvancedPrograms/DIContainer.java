package Reflection.AdvancedPrograms;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

interface Service {
    String performAction();
}

class ServiceImpl implements Service {
    @Override
    public String performAction() {
        return "Service action performed";
    }
}

class Client {
    @Inject
    private Service service;

    public void doSomething() {
        if (service != null) {
            System.out.println(service.performAction());
        } else {
            System.out.println("Service not injected");
        }
    }
}

public class DIContainer {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    public <T> T resolve(Class<T> clazz) {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();
            injectDependencies(instance);
            instances.put(clazz,instance);
            return instance;

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void injectDependencies(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = resolve(field.getType());
                if (dependency != null) {
                    field.set(obj, dependency);
                }
            }
        }
    }

    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Service.class, new ServiceImpl());

        Client client = container.resolve(Client.class);
        if (client != null) {
            client.doSomething();
        }
    }
}