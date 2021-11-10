<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/10/2021
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>

<body>
<p><c:if test='${message!=null}'>
    <span class="message">${message}</span>
</c:if></p>
<h1>Create Product Form</h1>
<fieldset>
    <legend>Product Information</legend>
    <form method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="des" id="des"></td>
            </tr>
            <tr>
                <td>Producer</td>
                <td><input type="text" name="producer" id="producer"></td>
            </tr>
            <td></td>
            <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
