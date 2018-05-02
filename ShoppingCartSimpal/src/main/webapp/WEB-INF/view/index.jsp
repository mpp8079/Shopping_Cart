<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>


h1 {
    color: red;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
    
}
a{
    color: #2da1c1;
    font-size: small;
    text-decoration: none;
    float: right;
}
a:hover
{
    color: #f90;
    text-decoration: underline;         
}
table, th, td {
    border: 1px solid black;
}
</style>
<%@ page isELIgnored="false" %>
<title>home_Page</title>
</head>
	<body>
		<h1>Jay Swaminarayn</h1>
		<h2>Well-Come to Home Page</h2>
		
		
		<h3>Pages</h3> 
		<a href="${pageContext.request.contextPath}/products">Product Info</a>	
		
		<a href="${pageContext.request.contextPath}/orders">Orders Info</a>	
	</body>
</html>