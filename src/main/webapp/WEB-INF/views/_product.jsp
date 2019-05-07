<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<div class="card" style="width: 18rem;">
		<h5 class="card-header">${param.name}</h5>
		<img class="card-img-left" style="height:15vw;object-fit:cover;" src="${param.imageUrl}">
		<div class="card-body">
			<p class="tag">Giá: ${param.price}$</p>
			<a href="#" class="btn btn-success btn-sm">Thêm vào giỏ hàng</a>
		</div>
	</div>
</body>
</html>