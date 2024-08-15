package exercise;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            for (Map<String, String> company : COMPANIES) {
                int number = Integer.parseInt(company.get("id"));
                if(number == id) {
                    ctx.json(company);
                } else if (id <= 0 || id > COMPANIES.size()) {
                    throw  new NotFoundResponse("Company not found");
                }
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
