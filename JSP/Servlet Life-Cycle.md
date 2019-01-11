# Servlet Life-Cycle

> 사용자의 요청에 의해서 생성된 servlet의 생명주기


> Servlet 생명 주기

![servlet-lifecycle](https://t1.daumcdn.net/cfile/tistory/991BDF455B43054B0F)


> 생명 주기 관련 메소드
    
- init() : 서블릿 최초로 호출 
- service() : doGet, doPost 메소드를 사용하여 서비스 제공
- destroy(): 서블릿 종료

~~~java
package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExmServlet
 */
@WebServlet("/ExmServlet")
public class ExmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    private void funPo() {
        System.out.println("PostConstruct 호출");

    }
    
    /**
     * @see Servlet#init(ServletConfig)
     * 서블릿 생성
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() 메소드 ");
    }
    
    // servlet 실행
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
        System.out.println("doGet() 메소드");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
        
        
    }

    
    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("destroy() 메소드");
    }
    
    @PreDestroy
    private void funPr() {
        System.out.println("PreDestory 호출");

    }

}
~~~

- 결과 

            PostConstruct 호출
            init() 메소드 
            doGet() 메소드
            doGet() 메소드
            1월 11, 2019 4:02:56 오후 org.apache.catalina.core.StandardContext reload
            정보: Reloading Context with name [/example02] has started
            destroy() 메소드
            PreDestory 호출