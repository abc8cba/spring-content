<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/spring-mvc-jdbc-crud/add-product" method="post" modelAttribute="product">
	<div align="center">
		<table border="1" width="30%" bgcolor="pink">
			<form:hidden path="productId"/>
			<tr>
				<th colspan="2"><h2>Add/Modify Product</h2></th>
			</tr>
			<tr>
				<td align="right"><label for="pt">Product Title*</label></td>
				<td><form:input type="text" id="pt" path="productName" /></td>
			</tr>
			<tr>
				<td align="right"><label for="cn">Company Name*</label></td>
				<td><form:input type="text" id="cn" path="companyName"/></td>
			</tr>
			<tr>
				<td align="right"><label for="prc">Price*</label></td>
				<td><form:input type="text" id="prc" path="price"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
					<input type="reset" value="Clear">
				</td>
			</tr>
		</table>
	</div>
</form:form>
</body>
</html>