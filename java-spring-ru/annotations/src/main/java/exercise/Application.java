package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var type = method.getReturnType().getComponentType();
                System.out.println("Method " + method.getName() + " returns a value of type " + method.getReturnType().getSimpleName());
            }
        }
        // END
    }
}
