<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
function memo_view(idx) {
	location.href="${path}/memo/view/"+idx;	
}
</script>

</head>
<body>
<%@ include file="../include/memu.jsp" %>

<h2>메모장</h2>
<form method="post" action="${path}/memo/insert.do">
	이름 : <input name="writer" size="10"><br>
	메모 : <input name="memo" size="40">
	<input type="submit" value="확인" >
</form>

<table border="1" width="500px">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
<c:forEach var="row" items="${list}">
	<tr>
		<th>${row.idx}</th>
		<th>${row.writer}</th>
		<th><a href="#" onclick="memo_view('${row.idx}')">
		${row.memo}</a></th>
		<th><fmt:formatDate value="${row.post_date}"
		pattern="yyyy-MM-dd HH:mm:ss"/></th>
	</tr>
</c:forEach>
</table>
</body>
</html>