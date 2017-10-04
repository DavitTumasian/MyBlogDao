<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<% if (session.getAttribute("message") != null) {%>
<%=session.getAttribute("message")%>
<% session.removeAttribute("message");}%>

<form method="post" action="/login">
    <p>Login: <input name="username" type="text"></p>
    <p>Password:<input name="password" type="password"></p>
    <p><input value="Login" type="submit"></p>


</form>

</body>
</html>
