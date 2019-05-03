<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Trang chủ</title>
	<link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<h1>Hello world!!!</h1>

	<p>The time on the server is ${serverTime}.</p>
	
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
