<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加商品页面</title>
</head>
<body>
	<form action="/webBuli/productCtrl/insert.mvc" method="get">
		商品名：<input type="text" name="name" /><br>
		价格：<input type="text" name="price" /> <br>
		备注：<textarea rows="5" cols="20" name="remark"></textarea>
		<button type="submit">添加商品</button>
		<!--input type="hidden" name="operateTypeInJSP" value="insert"  -->
	</form>
</body>
</html>