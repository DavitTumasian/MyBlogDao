<%@ page import="util.Constant" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Post" %>
<%@ page import="model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="css/CSS.css">
</head>
<body>


<div class="header_photo">
    <img src="image/summer.jpg" alt="image" name="headerPhoto" width="960" height="250">
</div>
<br><br>
<div class="post">
    <p>ALL POSTS</p>
    <%if (request.getAttribute("allPosts") != null) {%>
    <%List<Post> postList = (List<Post>) request.getAttribute("allPosts");%>
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
<br><br>
<div class="category">
    <p> ALL CATEGORIES</p>
    <%if (request.getAttribute("allCategories") != null) {%>
    <%List<Category> categoryList = (List<Category>) request.getAttribute("allCategories");%>
        <% for (Category category : categoryList) {%>
        <a href="/category?categoryId=<%=category.getId()%>">
    <%=category.getName()%></a><br><br>
    <%}%>
    <% } else {%>
    <%response.sendRedirect("error.jsp");%>
    <%} %>
</div>
<br><br><br><br><br><br>
<div class="admin">
    <a href="/admin">admin panel</a>
</div>

</body>
</html>
