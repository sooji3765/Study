# Servlet request, response

> HttpServlet 이란?

- 추상 클래스
- 클래스 상속 구조

![images](http://www.itfind.or.kr/Data2000/iita/other/B3-293/37-2.gif)

- 웹 서버와의 통신에서 데이터가 오고 가기 때문에 미리 구현
- 개발자는 HttpServlet 만 상속받아 서블릿을 구현한다.
 
~~~java
@WebServlet("/test")
public class ServletEx extends HttpServlet{

    protected void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws ServletException, IOException{        
        }
    }
~~~

> HttpServletRequest 

- 유저가 서버에 요청과 관련된 정보와 동작을 가지고 있는 객체
- ip , 쿠키, 헤더, get/post 등
- HttpServletRequest 메소드 정리 : http://www.devkuma.com/books/pages/1190

~~~java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        System.out.println(request.getContentType());
        System.out.println(request.getCookies());
        System.out.println(request.getSession());
    }

~~~


> HttpServletResponse

- 서블릿이 응답을 하는 것 , 즉 유저에게 결과 값을 넘기는 객체
- 클라이언트에 데이터를 전송하기 위하여 사용. 이를 위하여 Response객체의 
`setContentType()` 과 `getWriter()`메소드를 이용

~~~java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    
    System.out.println(response.getHeader("hello"));    
        
    }
~~~ 