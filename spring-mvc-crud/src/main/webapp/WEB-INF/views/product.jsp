<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<style type="text/css">
	.error{
		color:red;
		/* position: fixed;
		margin-left: 30px;
		text-align: left; */
	}
</style>
</head>
<body>
	<form:form action="/spring-mvc-crud/add-product" method="post"
		modelAttribute="productDTO">

		<div align="center">
			<table border="1">
				<form:hidden path="productId"/>
				<tr bgcolor="pink">
					<th colspan="2"><h2>Add/Modify New Product</h2></th>
				</tr>
				<tr>
					<td align="right"><label for="pt">Product Title*</label></td>
					<td>
						<form:input type="text" id="pt" path="productName" />
						<form:errors path="productName" cssClass="error"/>
					</td>
					
				</tr>
				<tr>
					<td align="right"><label for="cn">Company Name*</label></td>
					<td>
					    <form:input type="text" id="cn" path="companyName"/>
					    <form:errors path="companyName" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td align="right"><label for="prc">Price*</label></td>
					<td>
						<form:input type="text" id="prc" path="price"/>
						<form:errors path="price" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Add Product">
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>