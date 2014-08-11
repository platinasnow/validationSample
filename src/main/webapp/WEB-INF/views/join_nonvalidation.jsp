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
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
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
	<form method="post">
	
	<div class="panel panel-${color}">
		<div class="panel-heading">JOIN</div>
		<table class="table"> 
		<tr>
			<td>아이디</td>
			<td><input type="text" class="form-control" name="userId" value="${user.userId }" placeholder="아이디 (6~10자)"/></td>
			<td>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" class="form-control" name="name" value="${user.name }" placeholder="이름"/></td>
			<td>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" class="form-control" name="password" placeholder="비밀번호(8~16자)" /></td>
			<td>
			</td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" class="form-control" name="pwConfirm" placeholder="비밀번호 확인"/></td>
			<td>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" class="form-control" name="email" value="${user.email }" placeholder="이메일" /></td>
			<td>
			</td>
		</tr>
	</table>
	</div>
	
	<button type="button" class="btn btn-${color}" onclick="validation()">전송</button>
</form>
</div>
</body>
<script type="text/javascript">
	var form = document.forms[0];
	
	var validation = function(){
		if($('input[name=userId]').val() == ''){
			$('input[name=userId]').focus();
			alert('아이디를 입력하세요.');
			return;
		}else if($('input[name=name]').val() == ''){
			$('input[name=name]').focus();
			alert('이름을 입력하세요.');
			return;
		}else if($('input[name=password]').val() == ''){
			$('input[name=password]').focus();
			alert('비밀번호를 입력하세요.');
			return;
		}else if($('input[name=pwConfirm]').val() == ''){
			$('input[name=pwConfirm]').focus();
			alert('비밀번호 확인을 입력하세요.');
			return;
		}else if($('input[name=email]').val() == ''){
			$('input[name=email]').focus();
			alert('이메일을 입력하세요.');
			return;
		}else{
			form.submit();
		}
	};
</script>
</html>