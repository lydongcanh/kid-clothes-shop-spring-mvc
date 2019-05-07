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
	            <li class="nav-item">
	                <a class="nav-link" href="${contextPath}/loginPage">Tài khoản</a>
	            </li>
	        </ul>
    	</div>
    	
    	<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
	        <ul class="navbar-nav ml-auto">
	            <li class="nav-item">
	                <button type="button" class="btn btn-primary">
						Giỏ hàng <span class="badge badge-light">0</span> 
					</button>
	            </li>
	        </ul>
    	</div>
	</nav>
</body>
</html>