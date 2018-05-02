<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>

table, th, td {
    border: 1px solid black;
}
</style>
<%@ page isELIgnored="false" %>
<title>List Customers</title>
</head>
	<body>
		<input type="button" value="Add Product"			
					onclick="window.location.href='showFormForProductAdd';return false;"
				class="add-button"
			>
			<hr>
			<!-- add html table here -->
				<table>
				     <tr>
						<th>Code</th>
						<th>Create_Date</th>
						<th>Image</th>					
						<th>Name</th>
						<th>Price</th>
						<th>Action</th>
					</tr>					
					<c:forEach var="tempProduct" items="${products}">
					
					<!-- construct an delete link with customer id -->					
					<c:url var="deleteProduct" value="deleteProduct">
						<c:param name="code" value="${tempProduct.code}"/>
					
					</c:url>
						<tr>
						<td> ${tempProduct.code}</td>
						<td> ${tempProduct.createDate} </td>
						<td> ${tempProduct.image} </td>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.price} </td>
						<td> 
						<a href="${deleteProduct}" 
						onclick="if(!(confirm('Are you sure want to delete this item'))) return false">
						Delete</a> 
						
						
						
						</td>
										
					</tr>										
					</c:forEach>
				</table>	
				<hr>
				<a href="${pageContext.request.contextPath}/">back</a>	
	</body>
</html>