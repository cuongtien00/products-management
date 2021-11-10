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
    <title>Product Information</title>
</head>
<body>
<h1>Product Information</h1>
<p><a href="/products">Back to Products List</a></p>
<fieldset>
    <legend>Information</legend>
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
                <td><a href="/products?action=edit&id=${product.getId()}"><input type="submit"  value="Edit Information"></a></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="/products?action=delete&id=${product.getId()}"><input type="submit" value="Delete Product"></a></td>
            </tr>
        </table>
</fieldset>

</body>
</html>
