<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<title>Home</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/memu.jsp" %>

<c:if test="${sessionScope.userid!=null}">
	<h2>${sessionScope.name}
		(${sessionScope.userid})님의 방문을 환영합니다.
	</h2>
</c:if>
<h1>

	<%=application.getRealPath("/") %>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
