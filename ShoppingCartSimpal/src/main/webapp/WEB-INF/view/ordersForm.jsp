<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>List Customers</title>
</head>
	<body>
	<form:form  action="saveOrder" method="post" modelAttribute="orders">
	<table>
	<tbody>
			<tr>
			<td>ID :</td>
			<td><form:input path="id"/></td>
			</tr>			
			<tr>
			<td>Amount :</td>
			<td><form:input path="amount"/></td>
			</tr>
			<tr>
			<td>Address :</td>
			<td><form:input path="cusAddress"/></td>
			</tr>
			<tr>
			<td>Eamil :</td>
			<td><form:input path="cusEmail"/></td>
			</tr>
				<tr>
			<td>Name :</td>
			<td><form:input path="cusName"/></td>
			</tr>
			<tr>
			<td>Phone :</td>
			<td><form:input path="cusPhone"/></td>
			</tr>
			<tr>
			<td>Date :</td>
			<td><form:input path="orderDate"/></td>
			</tr>
			<tr>
			<tr>
			<td>Order Number :</td>
			<td><form:input path="orderNum"/></td>
			</tr>
			<tr>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
	</tbody>
	
	</table>
	</form:form>
	</body>
</html>