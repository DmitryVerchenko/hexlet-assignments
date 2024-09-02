@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    @for(var user : page.getUsers())
        <div>
            <h2><a href = "/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.getLastName()}</p>
            <p>${user.getEmail()}</p>
        </div>
    @endfor
`
)
