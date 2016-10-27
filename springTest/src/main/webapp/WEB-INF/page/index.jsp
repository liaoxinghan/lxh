<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<base href="${path}">
</head>
<body>
${path}
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

<form action="/springTest/view/checkParm" method="post">
	id:<input type="text" name="id"/>
	id:<input type="text" name="id"/>
	name:<input type="text" name="_name"/>
	1<input type="checkbox" name="love" value="1">
	2<input type="checkbox" name="love" value="2">
	3<input type="checkbox" name="love" value="3">
	4<input type="checkbox" name="love" value="4">
	<select name="city">
		<option value="0"></option>
		<option value="1">成都</option>
		<option value="2">广元</option>
		<option value="3">南昌</option>
		<option value="4">南充</option>
	</select>
	<input type="submit"/>
</form>
<form action="base/check" method="post">
	<img src="kaptcha.jpg" width="200" id="kaptchaImage" title="看不清，点击换一张" />  
	<br /><small>看不清，点击换一张</small> 
	请输入:<input type="text" name="kaptcha">
	<input type="submit"/>
</form>
</body>
<script type="text/javascript" src="/springTest/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#kaptchaImage').click(function() {$(this).attr('src','kaptcha.jpg?' + Math.floor(Math.random() * 100));});
	});
</script>
</html>
