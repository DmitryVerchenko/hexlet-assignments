package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        return  Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        }).get("/phones", ctx -> ctx.result(ctx.jsonMapper().toJsonString(Data.getPhones().toString(), ArrayList.class)))
                .get("/domains", ctx -> ctx.result(ctx.jsonMapper().toJsonString(Data.getDomains().toString(), ArrayList.class)));
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
