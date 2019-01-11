# JSP Request, Response

> Request 객체

- servlet의 request 객체와 비슷
- form 에서 사용자의 데이터를 받음

~~~html
<!-- form 태그로 데이터 전송 -->
<form action="/sign" method="get/post">
</form>

<%
    String name= request.getParameter("name");
    String password= request.getParameter("pass");
    String gender= request.getParameter("gender");
    String regidence= request.getParameter("residence");
%>
~~~

> Response 객체

- firstPage.jsp
~~~html
    <body>
        First PAGE </br>

        <!--  다른 페이지로 이동시 response 객체 이용 -->
        <%
            response.sendRedirect("secondPage.jsp")
        %>
    </body>
~~~

- secondPage.jsp
~~~html
    <body>
        Second Page
    </body>
~~~