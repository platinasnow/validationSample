<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style type="text/css">
	.error{color: red;}
	.container{margin: 50px auto;}
	td:nth-child(1){width:20%;}
	td:nth-child(2){width:40%;}
	td:nth-child(3){width:40%;}
</style>
</head>
<body>
<div class="container">
	<h2>${title }</h2>
	<form:form commandName="user" method="post">
	
	<div class="panel panel-${color}">
		<div class="panel-heading">JOIN</div>
		<table class="table"> 
		<tr>
			<td>아이디</td>
			<td><input type="text" class="form-control" name="userId" value="${user.userId }" placeholder="아이디 (6~10자)"/></td>
			<td><form:errors class="error" path="userId" /> </td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" class="form-control" name="name" value="${user.name }" placeholder="이름"/></td>
			<td><form:errors class="error" path="name" /> </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" class="form-control" name="password" placeholder="비밀번호(8~16자)" /></td>
			<td><form:errors class="error" path="password" /> </td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" class="form-control" name="pwConfirm" placeholder="비밀번호 확인"/></td>
			<td><form:errors class="error" path="pwConfirm" /> </td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" class="form-control" name="email" value="${user.email }" placeholder="이메일" /></td>
			<td><form:errors class="error" path="email" /> </td>
		</tr>
	</table>
	</div>
	
	<button type="submit" class="btn btn-${color}">전송</button>
</form:form>
</div>
</body>
</html>