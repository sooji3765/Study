# Session

> Session이란?

- 서버에서는 클라이언트를 구분하기 위해 세션 ID를 부여하며 <u>웹 브라우저가 `서버`에 접속해서 브라우저를 종료할 때까지 인증상태를 유지합니다.</u>

- 물론 접속 시간에 제한을 두어 일정 시간 응답이 없다면 정보가 유지되지 않게 설정이 가능 합니다.

- 사용자에 대한 정보를 서버에 두기 때문에 쿠키보다 보안에 좋지만, 사용자가 많아질수록 서버 메모리를 많이 차지하게 됩니다.

- 즉 동접자 수가 많은 웹 사이트인 경우 서버에 과부하를 주게 되므로 성능 저하의 요인이 됩니다.


> 세션의 동작 방식

1. 클라이언트가 서버에 접속 시 세션 ID를 발급
2. 클라이언트는 세션 ID에 대해 쿠키를 사용해서 저장 ( 이 때 쿠키 이름은 JSESSIONID이다. )
3. 클라이언트가 서버에 다시 접속 시 이 쿠키를 이용해서 세션 ID 값을 서버에 전달

> 세션의 특징

- 각 클라이언트에게 고유 ID를 부여
- 세션 ID로 클라이언트를 구분해서 클라이언트의 요구에 맞는 서비스를 제공
- 보안 면에서 쿠키보다 우수
- 사용자가 많아질수록 서버 메모리를 많이 차지하게 됨

> 세션의 사용 예
    
    로그인과 같이 보안상 중요한 작업을 수행할 때 사용


> Session구현


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
     <form action="loginCon" method="post">
        id: <input type="text" name="id"></br>
        password : <input type="password" name="pass"></br>
        <input type="submit" value="login">         
     </form>
</body>
</html>
~~~

~~~java
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/loginCon")
public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        
        System.out.println("ID:"+id+"PASSWORD:"+pass);
        
        PrintWriter out = response.getWriter();
        out.print("ID:"+id+"PASSWORD"+pass);
        
        HttpSession session =  request.getSession();
        session.setAttribute("memId", id);
        
        response.sendRedirect("loginok.jsp");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}

~~~