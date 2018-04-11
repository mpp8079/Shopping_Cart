<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>home_Page</title>
</head>
	<body>
		<h2>Jay Swaminarayn</h2>
		<h2>Well-Come to Home Page</h2>
		<hr>
		<h3>Pages</h3>
		<a href="${pageContext.request.contextPath}/products">Product Info</a>	
	</body>
</html>