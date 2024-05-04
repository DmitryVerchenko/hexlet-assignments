package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@AllArgsConstructor
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize() {
        return new ObjectMapper().writeValueAsString(this);
    }

    @SneakyThrows
    public static Car unserialize(String jsonValue) {
        return new ObjectMapper().readValue(jsonValue, Car.class);
    }

    // END
}
