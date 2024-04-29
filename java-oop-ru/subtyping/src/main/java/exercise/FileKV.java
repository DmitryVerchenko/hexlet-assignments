package exercise;

import java.util.HashMap;
import java.util.Map;

import static exercise.Utils.*;

// BEGIN
public class FileKV implements KeyValueStorage{
    public static void main(String[] args) {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
// Получение значения по ключу
        System.out.println(storage.get("key", "default")); // "value"

    }
    String filepath;
    Map<String,String> storage;

    public FileKV(String filepath, Map<String, String> storage) {
        this.filepath = filepath;
        this.storage = new HashMap<>(storage);
    }

    @Override
    public void set(String key, String value) {
        storage = unserialize(readFile(this.filepath));
        storage.put(key, value);
        writeFile(this.filepath, serialize(storage));
    }

    @Override
    public void unset(String key) {
        storage = unserialize(readFile(this.filepath));
        storage.remove(key);
        writeFile(this.filepath, serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>();
    }
}

// END
