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
	<input type="button" value="Add Order"
				onclick="window.location.href='showOrderForm';return false;"
				class="add-button"
			>
			<hr>
		
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
						<th>Action</th>
					</tr>					
					<c:forEach var="tempOrders" items="${orders}">					
					
					<c:url var="deleteOrder" value="deleteOrder">
						<c:param name="id" value="${tempOrders.id}"/>					
					</c:url>
						<tr>
						<td> ${tempOrders.id} </td>
						<td> ${tempOrders.amount} </td>
						<td> ${tempOrders.cusAddress} </td>
						<td> ${tempOrders.cusEmail} </td>
						<td> ${tempOrders.cusName} </td>
						<td> ${tempOrders.cusPhone} </td>
						<td> ${tempOrders.orderDate} </td>
						<td> ${tempOrders.orderNum} </td>
						<td>
						<a href="${deleteOrder}"
						onclick="if(!(confirm('Are you sure want to delete this Order'))) return false">
						Delete
						</a>
						</td>
										
					</tr>										
					</c:forEach>
				</table>	
				<hr>
				<a href="${pageContext.request.contextPath}/">back</a>	
	</body>
</html>