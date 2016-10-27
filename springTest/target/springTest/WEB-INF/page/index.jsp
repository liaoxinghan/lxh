<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<p>${people.name }1</p>
<p>${people.age }2</p>
<p>${people.phone }3</p>
<p>${people.id }4</p>
<a href="http://www.baidu.com">百度</a>

<form action="/springTest/view/delete/people" method="post">
	id:<input type="text" name="id"/>
	<input type="submit"/>
</form>
</body>
</html>
