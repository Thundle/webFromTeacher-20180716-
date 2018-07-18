<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加商品页面</title>
</head>
<body>
	<form action="/webBuli/ProductToServlet" method="post">
		商品名：<input type="text" name="thename" /><br>
		价格：<input type="text" name="theprice" /> <br>
		备注：<textarea rows="5" cols="20" name="theremark"></textarea>
		<button type="submit">添加商品</button>
	</form>
</body>
</html>