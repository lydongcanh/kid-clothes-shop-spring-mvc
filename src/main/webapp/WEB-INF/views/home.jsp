<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Trang chủ</title>
	<link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
		<c:forEach items="${productListModel.products}" var="product">
			<jsp:include page="_product.jsp">
				<jsp:param name="imageUrl" value="${product.imageUrl}"/>
				<jsp:param name="name" value="${product.name}"/>
				<jsp:param name="description" value="${product.description}"/>
				<jsp:param name="gender" value="${product.gender.toString()}"/>
			</jsp:include>
		</c:forEach>
		</div>
	</div>
	
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
