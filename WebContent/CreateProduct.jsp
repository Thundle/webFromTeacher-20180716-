<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加商品页面</title>
	<script type="text/javascript" src="/webBuli/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$.post('/webBuli/category/ajax.mvc',{keyword:''},function(result){
				console.info(result);
				$(result).each(function(){
					$('#sel').append("<option value=" + this.id + ">" + this.name + "</option")
				})
			})
		})
	</script>
</head>
<body>
	<form action="/webBuli/productCtrl/insert.mvc" method="get">
		商品名：<input type="text" name="name" /><br>
		价格：<input type="text" name="price" /> <br>
		备注：<textarea rows="5" cols="20" name="remark"></textarea>
		
		<select id="sel" name="category.id">
			<option value="0">---请选择---</option>
		</select>
		
		<button type="submit">添加商品</button>
		<!--input type="hidden" name="operateTypeInJSP" value="insert"  -->
	</form>
</body>
</html>