# Cookie

> HTTP가 쿠키와 세션을 사용하는 이유

    클라이언트가 요청을 한 후 응답을 받으면 그 연결을 바로 끊는다.
    통신이 끝나면 상태를 유지하지 않는다. - 서버의 과부화 발생 할수도

> Cookie 란?

- 서버와 클라이언트가 연결한 흔적, 기존 연결정보를 저장
- 클라이언트 측(브라우저)에서 관리되는 작은 기록 정보 파일을 의미합니다.
- 사용자 인증이 유효한 시간을 명시할 수 있으며, 유효 시간이 정해지면 브라우저가 종료되어도 인증이 유지된다는 특징이 있습니다.
- pc에 데이터가 저장되기 때문에 보안에 취약할수 있다.

> Cookie 구성 요소

1. 이름 : 각각의 쿠키를 구별하는 데 사용되는 이름
2. 값 : 쿠키의 이름과 관련된 값
3. 유효시간 : 쿠키의 유지시간
4. 도메인 : 쿠키를 전송할 도메인
5. 경로 : 쿠키를 전송할 요청 경로

> Cookie 동작 방식

1. 클라이언트가 페이지를 요청
2. 서버에서 쿠키를 생성
3. HTTP 헤더에 쿠키를 포함 시켜 응답
4. 브라우저가 종료되어도 쿠키 만료 기간이 있다면 클라이언트에서 보관하고 있음
5. 같은 요청을 할 경우 HTTP 헤더에 쿠키를 함께 보냄
6. 서버에서 쿠키를 읽어 이전 상태 정보를 변경 할 필요가 있을 때 쿠키를 업데이트 하여 변경된 쿠키를 HTTP 헤더에 포함시켜 응답

> 쿠키 사용 예

    방문 사이트에서 로그인 시, "아이디와 비밀번호를 저장하시겠습니까?"
    쇼핑몰의 장바구니 기능


[참고]https://victorydntmd.tistory.com/34

> Cookie 구현

1. cookie == null 여부 확인
2. `false`- cookie 재활용
3. `true`- cookie 생성


#### servlet.java
~~~java
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCon
 */
@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        
        out.print("id :"+id);
        out.print("pass :"+pass);
        
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        
        for(Cookie c :cookies) {
            System.out.println("c.getName"+c.getName()+", c.getValue:"+c.getValue());
            
            if(c.getName().equals("memberId")) {
                cookie = c;
            }
        }
        
        if(cookie == null) {
            System.out.println("cookie is null");
            cookie = new Cookie("memberId",id);
        }
        
        response.addCookie(cookie);
        cookie.setMaxAge(60*60);
        
        response.sendRedirect("loginok.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
~~~

#### form.html
~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% 
        Cookie[] cookies = request.getCookies();
        System.out.println("cookies:"+cookies);
        
        if(cookies !=null){
            for(Cookie c :cookies){
                if(c.getName().equals("memberId")){
                    response.sendRedirect("loginok.jsp");
                }
            }
        }
    %>
    
 <form action="LoginCon" method="post">
    id: <input type="text" name="id"></br>
    password : <input type="password" name="pass"></br>
    <input type="submit" value="login">         
 </form>
 
</body>
</html>
~~~


#### loginok.jsp
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
    <%
        Cookie[] cookies = request.getCookies();
    for(Cookie c : cookies){
        out.print("name:"+c.getName()+"</br>");
        out.print("value:"+c.getValue()+"</br>");
        out.print("-------------------");
    }
    %>
</body>
</html>
~~~