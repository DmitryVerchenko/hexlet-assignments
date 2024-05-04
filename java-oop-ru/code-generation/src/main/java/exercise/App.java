package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static exercise.Car.unserialize;

// BEGIN
public class App {
    public static void main(String[] args) {
        Path path1 = Paths.get("file1.json");
        var owner = new User(123,null,null,123);
        Car car1 = new Car(1, "audi", "q3", "black", owner);
        App.save(path1, car1); // Сохраняет представление объекта в файл

        Path path2 = Paths.get("file1.json");
        Car car2 = App.extract(path2); // Возвращает инстанс класса Car
        System.out.println(car2.getModel()); // "passat"

    }
    public static void save(Path path, Car car) {
        try {
            Files.write(pathToFullPath(path), car.serialize().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Car extract(Path path) {
        Path fullpath = pathToFullPath(path);
        String jsonParser;
        try {
            jsonParser = Files.readString(fullpath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return unserialize(jsonParser);
    }
    public static Path pathToFullPath(Path path) {
        String path1 = "src/test/resources";
        File file = new File(path1);
        String absolutePath = file.getAbsolutePath();
        Path resultPath = Path.of(String.valueOf(path));
        if (!path.startsWith("/")) {
            resultPath = Path.of(absolutePath + "/" + path);
        }
        if (new File(resultPath.toString()).exists()) {
            return resultPath;
        }
        throw new RuntimeException("File: " + resultPath + " does not exist");
    }
}

// END
