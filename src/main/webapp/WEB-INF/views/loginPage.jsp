<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Đăng nhập</title>
	<link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>

<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<div class="container-fluid">
		<form:form action="login">
			<div class="form-group">
				<label for="username">Tài khoản</label> 
				<input type="text" class="form-control" id="username" placeholder="Tài khoản"> 
			</div>
			<div class="form-group">
				<label for="password">Mật khẩu</label> 
				<input type="password" class="form-control" id="password" placeholder="Mật khẩu">
			</div>
			<button type="submit" class="btn btn-primary">Đăng nhập</button>
		</form:form>
	</div>
	
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>