# Servlet 데이터 공유


> Servlet Parameter

1. `init-param` 을 이용해 servlet 내에서 공통적으로 사용하는 데이터를 설정
    
    web.xml
    ~~~xml
    <init-param>
        <param-name>admiID</param-name>
        <param-value>amdin</param-value>
    </init-param>
    ~~~

2.  실제 자바 코드 내
    ~~~java
    String adminId = getServletConfig().getInitParameter("adminID");
    ~~~

> Context Parameter

- 어플리케이션 전체적으로 공유하는 데이터 

1. `context-param`을 이용해 application 이 공유하는 데이터 설정
    
    web.xml
    ~~~xml
    <context-param>
        <param-name>imgDir</param-name>
        <param-value>/upload/img</param-value>
    </context-param>
    ~~~

2. 실제 자바 코드 
    ~~~java
    String dir = getServletContext().getInitParameter("imgDir");
    ~~~

> Context Attribute

- 하나의 서블릿에서 `context`으로 설정하면 다른 서블릿에서 데이터 사용 가능

1. setAttribute()
    ~~~java
    getServletContext().setAttribute("connectedIP","165.65.32.63");
    ~~~
    
2. getAttribute()
    ~~~java
    String connectIp = (String)getServletContext.getAttribute("connectedIP");
    ~~~