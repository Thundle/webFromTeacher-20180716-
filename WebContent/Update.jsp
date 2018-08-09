<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>更新商品</title>
</head>
<body>

	<form action="/webBuli/productCtrl/update.mvc" method="post">
		商品名:<input type="text" name="name" value="${requestScope.product.name}" /><br /> 
		价格:<input type="text"
			name="price" value="${requestScope.product.price}" /><br /> 备注:
		<textarea name="remark" rows="5" cols="20">${requestScope.product.remark}</textarea>
		<button type="submit">更新商品</button>
		<input type="hidden" name="id" value="${requestScope.product.id}" >
	</form>
</body>
</html>