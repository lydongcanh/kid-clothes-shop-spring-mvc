<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<div class="card" style="width: 18rem;">
		<img class="card-img-top" style="height: 15vw;object-fit:cover;" src="${param.imageUrl}">
		<div class="card-body">
			<h5 class="card-title">${param.name}</h5>
			<p class="card-text">${param.description}</p>
			<p class="card-text">${param.gender}</p>
		</div>
	</div>
</body>
</html>