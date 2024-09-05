package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import exercise.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private Integer page;

    public boolean hasNextPage() {
        return PostRepository.getEntities().size() > page * 5 ;
    }

    public boolean hasPreviousPage() {
        return this.page > 1;
    }
}

// END


