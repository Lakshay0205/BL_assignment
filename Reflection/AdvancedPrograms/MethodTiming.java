package Reflection.AdvancedPrograms;
import java.lang.reflect.Method;

public class MethodTiming {

    public static void measureMethodTime(Object obj, String methodName, Object... args) {
        try {
            Class<?> clazz = obj.getClass();
            Class<?>[] parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }

            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true); // Allow access to private methods

            long startTime = System.nanoTime();
            method.invoke(obj, args);
            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;
            System.out.println("Method '" + methodName + "' execution time: " + executionTime + " nanoseconds");

        } catch (Exception e) {
            System.out.println("Error measuring method time: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        class MyClass {
            public void myMethod(int a, int b) {
                try {
                    Thread.sleep(10); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private String privateMethod(String input){
                try{
                    Thread.sleep(5);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                return input.toUpperCase();
            }
        }

        MyClass myObj = new MyClass();

        measureMethodTime(myObj, "myMethod", 10, 20);
        measureMethodTime(myObj, "privateMethod", "test string");
    }
}