<%@ page import="model.Post" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<div class="header_photo">
    <img src="image/summer.jpg" alt="image" name="headerPhoto" width="960" height="250">
</div>
<br><br>
<div class="category">

    <p><%=request.getAttribute("categoryName")%>
    </p>

    <%if (request.getAttribute("postByCategory") != null) {%>

    <%List<Post> postList = (List<Post>) request.getAttribute("postByCategory");%>
    <% for (Post post : postList) {%>
    <table border="1px">
        <tr>
            <td>
                <%= post.getTitle()%>
            </td>
        </tr>
        <tr>
            <td>
                <%= post.getTimeStamp()%>
            </td>
        </tr>
        <tr>
            <td>
                <img src="/getImage?image=<%=post.getImage()%>" width="200">
            </td>
        </tr>
        <tr>
            <td>
                <%=post.getDescription()%>
            </td>
        </tr>
    </table>
    <br><br>
    <%}%>
    <% } else {%>
    <%response.sendRedirect("error.jsp");%>
    <%} %>
</div>

<a href="/home">back</a>
</body>
</html>
