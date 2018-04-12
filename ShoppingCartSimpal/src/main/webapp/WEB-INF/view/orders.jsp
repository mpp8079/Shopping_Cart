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
						<th>ID</th>
						<th>Amount</th>
						<th>Customer Address</th>					
						<th>Customer Email</th>
						<th>Customer Name</th>
						<th>Customer Phone</th>
						<th>Order Date</th>
						<th>Order Number</th>
					</tr>					
					<c:forEach var="tempOrders" items="${orders}">					
						<tr>
						<td> ${orders.id} </td>
						<td> ${orders.amount} </td>
						<td> ${orders.cusAddress} </td>
						<td> ${orders.cusEmail} </td>
						<td> ${orders.cusName} </td>
						<td> ${orders.cusPhone} </td>
						<td> ${orders.orderDate} </td>
						<td> ${orders.orderNum} </td>
										
					</tr>										
					</c:forEach>
				</table>	
				<hr>
				<a href="${pageContext.request.contextPath}/">back</a>	
	</body>
</html>