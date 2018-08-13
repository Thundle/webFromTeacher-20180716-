<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询商品</title>
 <script type="text/javascript"></script>
</head>
<body>
	<form action="/webBuli/productCtrl/selectByName.mvc" method="post">
		查询关键字:<input type="text" name="querykeyword" value="${sessionScope.querykeyword}" />
		<button type="submit">给我搜</button>
	</form>
	<table width="800" border="1">
	    <!-- tr代表行 td代表列 th:标题 -->
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>备注</th>
			<th>日期</th>
			<th>所属类别</th>
			<th>操作</th>
		</tr>
		 <!-- items:循环的集合    var:循环的每个对象-->
		 <!-- session.getAttribute("pList") -->
		<c:forEach items="${requestScope.pListFromCtrl}" var="p">
			 <!-- 循环一行 -->
			 <tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.remark}</td>
				<td>${p.date}</td>
				<td>${p.category.name}</td>
				<td>
					<a href="/webBuli/productCtrl/delete.mvc?id=${p.id}">删除</a>
					|ajax删除
					|<a href="/webBuli/productCtrl/selectById.mvc?id=${p.id}">更新</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>