<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Trang chủ</title>
	<link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<link href="resources/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_header.jsp">
		<jsp:param name="isLoggedIn" value="${homeModel.headerModel.isLoggedIn()}"/>
		<jsp:param name="productCount" value="${homeModel.headerModel.productInCart}"/>
	</jsp:include>
	
	<div class="container-fluid">
		<!-- Search bar -->
		<nav class="navbar navbar-expand-md navbar-light bg-light">
			<!-- Brands dropdown -->
			<div class="nav-item dropdown">
				<a class="nav-link dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Nhãn hiệu</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeModel.brands}" var="brand">
						<a class="dropdown-item" href="#">${brand.name}</a>
					</c:forEach>
				</div>
			</div>
			
			<!-- Sizes dropdown -->
			<div class="nav-item dropdown">
				<a class="nav-link dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Kích thước</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeModel.sizes}" var="size">
						<a class="dropdown-item" href="#">${size.size}</a>
					</c:forEach>
				</div>
			</div>
			
			<!-- Types dropdown -->
			<div class="nav-item dropdown">
				<a class="nav-link dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Loại</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeModel.types}" var="type">
						<a class="dropdown-item" href="#">${type.name}</a>
					</c:forEach>
				</div>
			</div>
		
			<!-- Search name -->
			<div class="navbar-nav ml-auto">
				<form class="form-inline" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nhập tên sản phẩm">
					</div>
					<button type="submit" class="btn btn-primary">Tìm</button>
				</form>
			</div>
		</nav>
		
		<!-- Product list -->
		<div class="row">
			<c:forEach items="${homeModel.productList.list}" var="product">
				<jsp:include page="_product.jsp">
					<jsp:param name="productId" value="${product.id}"/>
					<jsp:param name="imageUrl" value="${product.imageUrl}"/>
					<jsp:param name="name" value="${product.name}"/>
					<jsp:param name="price" value="${product.price}"/>
				</jsp:include>
			</c:forEach>
		</div>
	</div>
	
	<jsp:include page="_footer.jsp"></jsp:include>
	
	<script src="resources/jquery/jquery-3.4.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
