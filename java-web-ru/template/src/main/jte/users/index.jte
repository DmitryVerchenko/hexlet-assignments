@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <title></title>
</head>
<body>
<h1>Users</h1>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h2><a href = "/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.getLastName()}</p>
            <p>${user.getEmail()}</p>
        </div>
    @endfor
@endif
</body>
</html>