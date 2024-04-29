package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static exercise.Utils.readFile;
import static exercise.Utils.unserialize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testSetAndUnset() {
        var storage = new FileKV(filepath.toString(), unserialize(readFile(filepath.toString())));
        storage.set("key2", "value2");
        storage.set("key", "value");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key", "default")).isEqualTo("value");
        storage.unset("key");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key", "default")).isEqualTo("default");
    }

    @Test
    public void testGet() {
        var storage = new FileKV(filepath.toString(), unserialize(readFile(filepath.toString())));
        storage.set("key", "value");
        var actual = storage.get("key", "default");
        var expected = "value";
        assertEquals(actual, expected);
    }
    // END
}
