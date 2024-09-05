@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page


@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все статьи</h1>
            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                        <td><a href="${NamedRoutes.postPath(post.getId())}">${post.getId()}</a></td>
                        </td>
                        <td>
                            ${post.getName()}
                        </td>
                        <td>
                            ${post.getBody()}
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
    <nav aria-label="...">
        <ul class="pagination">
            @if (page.hasPreviousPage())
                <li class="page-item">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous</a>
                </li>
            @else
                <li class="page-item disabled">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous</a>
                </li>
            @endif
            @if (page.hasNextPage())
                <li class="page-item">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next</a>
                </li>
            @else
                <li class="page-item disabled">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next</a>
                </li>
            @endif
        </ul>
    </nav>
`
)
