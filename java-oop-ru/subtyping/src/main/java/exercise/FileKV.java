package exercise;

import java.util.HashMap;
import java.util.Map;

import static exercise.Utils.readFile;
import static exercise.Utils.unserialize;
import static exercise.Utils.writeFile;
import static exercise.Utils.serialize;


// BEGIN
public class FileKV implements KeyValueStorage {
    String filepath;
    Map<String, String> storage;

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
