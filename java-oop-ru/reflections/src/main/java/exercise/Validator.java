package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static void main(String[] args) {
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields); // =>  {country=[length less than 4], street=[can not be null]}
    }

    public static List<String> validate(Address address) {
        var result = new ArrayList<String>();
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        var result = new HashMap<String, List<String>>();
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    var string = new ArrayList<String>();
                    string.add("can not be null");
                    result.put(field.getName(), string);
                } else if (field.isAnnotationPresent(MinLength.class) && field.get(address).toString().length() < 4) {
                    var string = new ArrayList<String>();
                    string.add("length less than 4");
                    result.put(field.getName(), string);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
// END
