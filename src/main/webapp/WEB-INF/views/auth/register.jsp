<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <sec:csrfMetaTags/>
</head>
<body>
    <h1>Rejestracja</h1>

    <form method="post" action="/registration">

        <div>Username: <input type="text" name="username"></div>

        <div>Password: <input type="password" name="password"></div>
        <div><input type="submit" value="Zarejestruj się"/></div>
    </form>
</body>
</html>
