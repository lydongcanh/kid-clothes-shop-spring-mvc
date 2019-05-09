<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<nav class="navbar sticky-top navbar-expand-md navbar-dark bg-dark">
	    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
	        <ul class="navbar-nav mr-auto">
	            <li class="nav-item active">
	                <a class="nav-link" href="${contextPath}/">Trang chủ</a>
	            </li>
	            <c:if test="${!param.isLoggedIn}">
		            <li class="nav-item">
		                <a class="nav-link" href="${contextPath}/loginPage">Đăng nhập</a>
		            </li>
	            </c:if>
	            <c:if test="${param.isLoggedIn}">
		            <li class="nav-item dropdown">
		            	<a class="nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tài khoản</a>
		                <div class="dropdown-menu">
		                	<a class="dropdown-item" href="#">Hóa đơn</a>
		                	<a class="dropdown-item" href="#">Thông tin</a>
		                	<a class="dropdown-item" href="${contextPath}/logout">Đăng xuất</a>
		                </div>
		            </li>
	            </c:if>
	        </ul>
    	</div>
    	
    	<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
	        <ul class="navbar-nav ml-auto">
	            <li class="nav-item">
	                <a href="${contextPath}/cart" class="btn btn-primary">
						Giỏ hàng <span class="badge badge-light">${param.productCount}</span>
					</a>
	            </li>
	        </ul>
    	</div>
	</nav>
</body>
</html>