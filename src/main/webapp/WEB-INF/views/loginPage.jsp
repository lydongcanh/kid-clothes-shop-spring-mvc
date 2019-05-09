<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Đăng nhập</title>
	<link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>

<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<div class="container" style="width:50%">
		<form method="POST" action="login">
			<div class="form-group">
				<label class="label label-default" for="email">Email</label> 
				<input id="email" type="email" value="${loginModel.email}" class="form-control" name="email" placeholder="Email"> 
			</div>
			<div class="form-group">
				<label class="label label-default" for="password">Mật khẩu</label> 
				<input id="password" type="password" value="${loginModel.password}" class="form-control" name="password" placeholder="Mật khẩu">
			</div>
			
			<c:if test="${loginModel.errorMessage != null}">
				<p class="text-danger">${loginModel.errorMessage}</p>
			</c:if>
			<button type="submit" class="btn btn-primary">Đăng nhập</button>
		</form>
	</div>
	
<%-- 	<jsp:include page="_footer.jsp"></jsp:include> --%>
</body>
</html>