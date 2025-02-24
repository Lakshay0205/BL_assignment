package Reflection.IntermediatePrograms;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class MyClass {

    public void someMethod() {
    }
}

public class AnnotationRetrieval {

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("MyClass");
            if (cls.isAnnotationPresent(Author.class)) {
                Author authorAnnotation = cls.getAnnotation(Author.class);
                System.out.println("Author: " + authorAnnotation.name());
            } else {
                System.out.println("Author annotation not found.");
            }

            Method method = cls.getMethod("someMethod");
            if(method.isAnnotationPresent(Author.class)){
                Author methodAuthor = method.getAnnotation(Author.class);
                System.out.println("Method Author: " + methodAuthor.name());
            }

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}