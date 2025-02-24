package Reflection.BasicPrograms;
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodInvocation {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);

            int result = (int) multiplyMethod.invoke(calculator, 5, 10);
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}