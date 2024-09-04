@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label>
            Name
            <input type="text" name="name" value="${page.getTitle()}" />
        </label>
    </div>
    <div>
        Content
        <label>
            <p>Text</p>
            <textarea name="content" value="${page.getContent()}"></textarea>
        </label>
    </div>
    <input type="submit" value="Add article" />
</form>
`
)
