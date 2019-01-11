# FORM 데이터 처리

> form 태그

##### Browser ===========> Servlet

- form 태그 : user data 정보를 가짐
- request 객체는 user data를 가짐

> doGet() 처리

- 데이터가 웹브라우저 URL에 노출되어 웹 서버로 전송
- 보안에 약함
- http://localhost:8090/lex/mSingup?<u>user=hong&pass=1234</u>
- 정보를 조회하기 위한 메소드


> doPost() 처리    

- 데이터가 HTTP Request에 포함되어 웹 서버로 전송
- http://localhost:8090/lect90/<u>mSignUp</u>
- 맵핑 정보만 노출,보안에 강하다.
- Http 패킷의 BODY에 파라미터를 전송한다.
- 전송하는 길에게 제한이 없이 대용량 전송을 하는데 적합하다.


> 예제

FOMR.HTML
~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- post 방식 전송 -->
 <form action="mSignUp" method="post">
    name: <input type="text" name="name"></br>
    password : <input type="password" name="pass"></br>
    gender : Man<input type="radio" name="gender" value="man">, 
    WOMAN <input type="radio" name="gender" value="woman"></br>
    residence : <select name="residence">
                    <option value="seoul" selected="selected">SEOUL</option>
                    <option value="busan" >BUSAN</option>
                    <option value="jeju" >JEJU</option> 
                </select></br>
    <input type="submit" value="sign up">           
 </form>
</body>
</html>
~~~

mSignServlet.java

~~~java
package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Helloservlet
 */
@WebServlet("/mSignUp")
public class Helloservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Helloservlet() {
        super();
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----doGet()-------------");
        
        String name= request.getParameter("name");
        String password= request.getParameter("pass");
        String gender= request.getParameter("gender");
        String regidence= request.getParameter("residence");
        
        
        System.out.println("name:"+name);
        System.out.println("password:"+password);
        System.out.println("gender:"+gender);
        System.out.println("regidence:"+regidence);
        
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()) {
            String nams = (String)names.nextElement();
            System.out.println("name="+nams);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        System.out.println("--------doPost()----- ");
        doGet(request, response);
    }

}
~~~