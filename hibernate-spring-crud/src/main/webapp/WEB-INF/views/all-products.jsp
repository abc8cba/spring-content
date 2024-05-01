<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manager Home</title>
    </head>
    <body>
        <div align="center" bgcolor="lime">
            <h1>Product List</h1>
            <h3><a href="/hibernate-spring-crud/product/add-product">Add New Product</a></h3>
            <table border="1">
            	<tr>
	                <th>Product Id</th>
	                <th>Title</th>
	                <th>Company Name</th>
	                <th>Price</th>
	                <th colspan="2">Action</th>
                </tr>
                 
                <c:forEach var="product" items="${productList}" >
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.companyName}</td>
                    <td>${product.price}</td>
                    <td>
                        <a href="/hibernate-spring-crud/product/editProduct?id=${product.productId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/hibernate-spring-crud/product/deleteProduct?id=${product.productId}">Delete</a>
                    </td>                            
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>