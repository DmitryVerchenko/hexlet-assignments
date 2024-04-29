package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage dictionary) {
        for (Map.Entry<String, String> pair : dictionary.toMap().entrySet()) {
            dictionary.unset(pair.getKey());
            dictionary.set(pair.getValue(), pair.getKey());
        }
    }
}

// END
