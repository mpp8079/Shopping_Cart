<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>List Customers</title>
</head>
	<body>
	<form:form  action="saveProduct" method="POST"   modelAttribute="products">
	<table>
	<tbody>
			<tr>
			<td>Code :</td>
			<td><form:input path="code"/></td>
			</tr>			
			<tr>
			<td>Create_Date :</td>
			<td><form:input path="createDate"/></td>
			</tr>
			<tr>
			<td>Image :</td>
			<td><form:input path="image"/></td>
			</tr>
			<tr>
			<td>Name :</td>
			<td><form:input path="name"/></td>
			</tr>
			<tr>
			<td>Price :</td>
			<td><form:input path="price"/></td>
			</tr>
			<tr>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
	</tbody>
	
	</table>
	</form:form>
	</body>
</html>