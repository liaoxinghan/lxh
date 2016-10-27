<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<table>
	<thead>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>age</td>
			<td>phone</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${peoples }" var="people">
			<tr>
				<td>${people.id }</td>
				<td>${people.name }</td>
				<td>${people.age }</td>
				<td>${people.phone }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="http://www.baidu.com">百度</a>
<form action="/springTest/view/delete/people" method="post">
	id:<input type="text" name="id"/>
	<input type="submit"/>
</form>
</body>
</html>
