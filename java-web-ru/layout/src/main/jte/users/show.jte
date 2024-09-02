@import exercise.dto.users.UserPage
@import exercise.model.User
@param UserPage page
@param User user

@template.layout.page(
content = @`
    <h3>${"User"}</h3>
    <div>${"User ID: " + page.getUser().getId()}</div>
    <div>${"User first name: " + page.getUser().getFirstName()}</div>
    <div>${"User last name: " + page.getUser().getLastName()}</div>
    <div>${"User Email: " + page.getUser().getEmail()}</div>
`
)