<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>List Customers</title>
</head>
	<body>
		
			<!-- add html table here -->
				<table>
				     <tr>
						<th>Code</th>
						<th>Create_Date</th>
						<th>Image</th>					
						<th>Name</th>
						<th>Price</th>
					</tr>					
					<c:forEach var="tempProduct" items="${products}">					
						<tr>
						<td> ${tempProduct.code} </td>
						<td> ${tempProduct.createDate} </td>
						<td> ${tempProduct.image} </td>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.price} </td>
										
					</tr>										
					</c:forEach>
				</table>	
				<hr>
				<a href="${pageContext.request.contextPath}/">back</a>	
	</body>
</html>