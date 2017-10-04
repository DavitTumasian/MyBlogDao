<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page import="dao.AdminDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>

<%if (session.getAttribute("categoryMessage") != null) {%>
<%=session.getAttribute("categoryMessage")%>
<%session.removeAttribute("categoryMessage");%>
<%}%>
<form name="add_category" method="post" action="/addCategory">
    <p>add category</p>
    <p>name: <input name="categoryName" type="text"></p>
    <p><input type="submit" value="add"></p>
</form>

<%if (session.getAttribute("postMessage") != null) {%>
<%=session.getAttribute("postMessage")%>
<%session.removeAttribute("postMessage");%>
<%}%>
<form name="add_post" method="post" action="/addPost" enctype="multipart/form-data">
    <p>add post</p>
    <p>title: <input type="text" name="title"></p>
    <p>image: <input type="file" name="image"></p>
    <p>category: <select name="categoryNamePost">
        <%if (request.getAttribute("allCategories") != null) {%>
        <% List<Category> categories = (List<Category>) request.getAttribute("allCategories");%>
        <% for (Category category : categories) {%>
        <option value="<%=category.getName()%>">
            <%=category.getName()%>
        </option>
        <%}%>
        <%} else {%>
        <span>Please add category.</span>
        <%}%>
    </select>
    </p>
    <p>descrition: <input type="text" name="description"></p>
    <p><input type="submit" value="add"></p>
</form>

<a href="/logout"><input type="button" value="Logout"></a>
</body>
</html>
