# JSP 스크립트

> Servlet vs JSP

1. Servlet

- 순수 자바 코드 
- xxx.java =====> xxx.class

2. JSP

- HTML + java 코드 
- xxx.jsp ======> xxx_jsp.java ======> xxx_jsp.class



> JSP 주요 스크립트

1. 선언 태그 : JSP페이지에서 java의 멤버변수 또는 메소드를 선언

    ~~~html
    <%!
        int num = 10;
        String str ="jsp";
        ArrayList<String> list = new ArrayList<String>();

        public void jspMethod(){
            System.out.println("-----jspMethod()");
        }
    %>
    ~~~

2. 주석 태그 : jsp주석은 jsp파일이 서블릿 파일로 변환될때 제거

    ~~~html
    <!-- 주석 테그 -->   // HTML 주석
    <%-- hello jsp --%> // JSP 주석
    ~~~

3. 스크립트릿 태그

    ~~~html
    <% 
        if(num > 0){
    %>
        <p> name > 0 </p>
    <% 
        }else{
    %>
        <p>num <=0</p>
    <% 
        }
    %>    
    ~~~

4. 표현식 태그 : Java의 변수 및 메서드의 반환값을 출력하는 태그
    
    ~~~html
     num is <%=num %>
    ~~~

5. 지시어 : 서버에서 jsp 페이지를 처리하는 방법에 대한 정의
    
    1. page : 페이지 기본 설정 
        - <%page 속성="속성 값" >
        ~~~html
        <%page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
        
        ~~~

    2. include : include file 설정
        - <%include file="파일명" >
        ~~~html
        <%include file="header.jsp" %>
        ~~~ 
    
    3. taglib : 외부라이브러리 태그 설정
        - <%taglib uri="uri" prefix="네임스페이스명" >
        ~~~html
        <% taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        ~~~    
