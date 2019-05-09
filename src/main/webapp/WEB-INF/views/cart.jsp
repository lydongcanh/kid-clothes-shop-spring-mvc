<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Giỏ hàng</title>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_header.jsp">
		<jsp:param name="isLoggedIn" value="${cartModel.headerModel.isLoggedIn()}"/>
		<jsp:param name="productCount" value="${cartModel.headerModel.productInCart}"/>
	</jsp:include>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Sản phẩm</th>
				<th scope="col">Số lượng</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cartModel.cartDetails.list}" var="cartdetail">
				<tr>
					<th scope="col">${cartdetail.productId}</th>
					<th scope="col">${cartdetail.quantity}</th>
					<th>
						<a href="${pageContext.request.contextPath}/removeProductFromCart/${cartdetail.productId}" class="btn btn-danger">Xóa</a>
					</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/">Tiếp tục mua hàng</a>
	
	<c:if test="${cartModel.cartDetails.list.size() > 0}">
		<a class="btn btn-primary" href="#">Thanh toán</a>
	</c:if>
		
	<script src="resources/jquery/jquery-3.4.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>