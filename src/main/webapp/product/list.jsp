<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/10/2021
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products List</title>
</head>
<body>
<h1>Products List</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="p">
        <tr>
            <td><a href="/products?action=view&id=${p.getId()}">${p.getName()}</a></td>
            <td>${p.getPrice()}</td>
            <td>${p.getDes()}</td>
            <td>${p.getProducer()}</td>
            <td><a href="/products?action=edit&id=${p.getId()}">Edit</a></td>
            <td><a href="/products?action=delete&id=${p.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
