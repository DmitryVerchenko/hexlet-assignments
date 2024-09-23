package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    private String message;

    @PostConstruct
    public void init() {
        this.message = "night";
        System.out.println(message);
    }
    // END
}
