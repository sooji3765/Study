# Servlet 맵핑

> Servlet 맵핑이란?

-  사용자가 어떤 정보를 요청할때, 요구하는 서블릿을 구분하고 보안의 취약점을 해결.

1. web.xml 파일을 이용한 맵핑
	
	- `web.xml` : deployment descriptor 배치 지시자

	~~~xml

    <!-- 서블릿 등록 -->
	<servlet>
		<servlet-name>servletEx</servlet-name>
        <!-- 서블릿 full name -->
		<servlet-class>com.servlet.ServletEx</servlet-class>
	</servlet>
    <!-- url mapping -->
	<servlet-mapping>
		<servlet-name>servletEx</servlet-name>
		<url-pattern>/SE</url-pattern>
	</servlet-mapping>
	~~~

	- 결과 : `http://localhost:8080/lec05/SE` 로 출력


2. Java Annotation을 이용한 맵핑 

    - 서블릿 파일에서 어노테이션 등록
    
    - 결과 : `http://localhost:8080/lec05/SE` 로 출력
    
    ~~~java

    // 어노테이션 등록
    @WebServlet("/SE")
    public class ServletEx extends HttpServlet{

        protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head><title>Servlet</title></head>");
            out.print("<body>");
            out.print("Hello Servlet");
            out.print("</body>");
            out.print("</html>");
        }
    }
    ~~~
    
