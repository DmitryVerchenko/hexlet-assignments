package exercise.controller;

import java.util.Collections;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class)
                .check(value -> value.length() > 1, "Название не должно быть короче двух символов")
                .get();
        var body = ctx.formParam("body");

        var post = new Post(name, body);
        PostRepository.save(post);

        ctx.sessionAttribute("flash", "Post was successfully created!");
        ctx.redirect(NamedRoutes.postsPath());
    }

    public static void index(Context ctx) {
        var flash = ctx.consumeSessionAttribute("flash");
        var term = ctx.formParam("term");
        var page = new PostsPage(PostRepository.getEntities(), term);
        page.setFlash((String) flash);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}