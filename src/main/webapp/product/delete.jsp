<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/10/2021
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product Form</h1>
<p><a href="/products">Back to products list</a></p>

<fieldset>
    <legend>Product information</legend>
    <form method="post">
        <table>
            <tr>
                <td>Name</td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Price</td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${product.getDes()}</td>
            </tr>
            <tr>
                <td>Producer</td>
                <td>${product.getProducer()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"  value="Delete Product"></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
