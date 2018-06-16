<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Shop Online</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
	<fmt:setLocale value="en_US" scope="session" />

	<div class="page-title">Product List</div>



	<c:forEach items="${paginationProducts.list}" var="prodInfo">
		<div class="product-preview-container">
			<ul>
				<li><img class="product-image"
					src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}" /></li>
				<li>Code: ${prodInfo.code}</li>
				<li>Name: ${prodInfo.name}</li>
				<li>Price: <fmt:formatNumber value="${prodInfo.price}"
						type="currency" /></li>
				<li><a
					href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
						Buy Now</a></li>
			</ul>
		</div>
	</c:forEach>
	<br />

	<c:if test="${paginationProducts.totalPages > 1}">
		<div class="page-navigator">
			<c:forEach items="${paginationProducts.navigationPages}" var="page">
				<c:if test="${page != -1 }">
					<a href="productList?page=${page}" class="nav-item">${page}</a>
				</c:if>
				<c:if test="${page == -1 }">
					<span class="nav-item"> ... </span>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
	<hr>
	<a href="${pageContext.request.contextPath}/">back</a>
</body>
</html>