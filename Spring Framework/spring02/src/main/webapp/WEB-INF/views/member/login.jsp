<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function() {
		$("#btnLogin").click(function() {
			var userid=$("#userid").val();
			var passwd=$("#passwd").val();
			if(userid==""){
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return;
			}
			if(passwd==""){
				alert("비밀번호를 입력하세요.");
				$("#passwd").focus();
				return;
			}
			document.form1.action="${path}/member/login_check.do";
			document.form1.submit();
		});
	});
</script>
</head>
<body>
<%@ include file="../include/memu.jsp" %>
<h2>로그인</h2>
<form method="post" name="form1" >
<table border="1" width="400px">
	<tr>
		<td>아이디</td>
		<td><input name="userid" id="userid"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd" id="passwd"></td>
	</tr>
	<tr>
	<td colspan="2" align="center">
		<input type="button" id="btnLogin" value="로그인">
		<c:if test="${message =='error'}">
			<div style="color: red;">
				아이디 또는 비밀번호가 일치하지 않습니다.
			</div>
		</c:if>
		<c:if test="${message =='logout'}">
			<div style="color: blue;">
				로그아웃 처리되었습니다.
			</div>
		</c:if>
	</td>
	</tr>
</table>
</form>
</body>
</html>