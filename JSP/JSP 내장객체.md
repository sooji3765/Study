# JSP 내장객체

> config 객체
 
 - web.xml 에서 `init param` 으로 `getinitParameter()` 메소드로 jsp에서 사용
 - 처음 서블릿에서 초기화된 파라미터 사용
 - JSP 페이지에 대한 설정 정보를 저장하고 있는 객체 

web.xml
~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>example02</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <!-- 서블릿 설정 -->
  <servlet>
    <servlet-name>jsp</servlet-name>
    <jsp-file>/jspEx.jsp</jsp-file>
    <!-- config 객체를 사용하기 위한 init param -->
    <init-param>
        <param-name>adminId</param-name>
        <param-value>admin</param-value>
    </init-param>
    <init-param>
        <param-name>adminPw</param-name>
        <param-value>1234</param-value>
    </init-param>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>/jspEx.jsp</url-pattern>
  </servlet-mapping>
  
</web-app>
~~~

jspEx.jsp
~~~html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%! 
        String adminId;
        String adminPw;
    %>
    
    <!-- config 객체 사용 -->
    <% 
        adminId = config.getInitParameter("adminId");
        adminPw = config.getInitParameter("adminPw");
    %>
    
    <p>adminId : <%=adminId %></p>
    <p>adminPw : <%=adminPw %></p>
</body>
</html>
~~~

> application 객체
 
 - 웹 어플리케이션 Context의 정보를 저장하고 있는 객체
 - context param으로 설정

 ~~~xml
 <!-- application  -->
  <context-param>
    <param-name>imgDir</param-name>
    <param-value>/upload/img</param-value>
  </context-param>
  <context-param>
    <param-name>testServerIP</param-name>
    <param-value>127.0.0.1</param-value>
  </context-param>
  <context-param>
    <param-name>realServerIP</param-name>
    <param-value>68.0.30.1</param-value>
  </context-param>
 ~~~

 ~~~html
 <body>
 <%!
    String img
 %>
 <%
    img = application.getInitParameter("imgDir");
 %>
 </body>
 ~~~

> out 객체

 - JSP 페이지에 출력할 내용을 가지고 있는 출력 스트림 객체

~~~html
<%
     out.print("<h1>hello java world</h1>");
%>
~~~

> exception 객체
 
 - JSP 페이지서 예외가 발생한 경우에 사용되는 객체

 ~~~html
 <!-- 에러 처리-->
 <!-- 페이지 지시어로 에러 페이지 설정 -->
 <%@ page errorPage="error.jsp" %>

 <%
    out.print(str.toString());
 %>
 ~~~

 error.jsp

~~~html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page IsErrorPage="true"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% 
    response.setStatus(200);
    String msg = exception.getMessage();
   %>

   <p>error Message : <%= msg %></p>
</body>
</html>
~~~

> pageContext 객체

 - JSP페이지에 대한 정보를 저장하고 있는 객체
 