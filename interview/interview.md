# 기술 면접 정리

>JAVA Interview

1. JAVA
  - 미국의 Sun MicroSystem에서 개발한 객체 지향 프로그래밍 언어

    JAVA의 특징
    - 자바가상머신(JAVA Virture Machine)만 설치하면 컴퓨터의 운영
    체제에 상관 없이 작동한다. ==> <u> 운영체제에 독립적</u>
        JDK - Java Development Kit
        JRE - Java Runtime Environment  ** 이것
    - 기본 자료형을 제외한 모든 요소들이 객체로 표현
    - 객체 지향 개념의 특징인  <u>캡슐화</u>, <u>상속</u> , <u>다형성</u> , <u>추상화</u> 가 잘 적용된 언어
    - Garbage Collector를 통한 자동적인 메모리 관리 (가비지 컬렉션)
      필요 없는 메모리는 자동으로 수집해서 정리함, c언어는 메모리 할당된것을 프로그래머가 정리를 해야함 -> 메모리 누수 현상 발생
    - 멀티쓰레드를 지원
    - 포인터 연산자가 없다.
    - 엄격한 형 검사를 수행하여 에러를 조기에 발견
    - 예외 처리 기능


2. OOP(객체지향 프로그래밍) <-> 절차 지향언어
  - Object-Oriented Programming의 약어로써 객체지향 프로그래밍을 의미 데이터를 객체로 취급하여 프로그램에 반영한 것이며, 순차적으로 프로그램이 동작하는 절차지향적인 프로그래밍과 다르게 <u>객체와 객체의 상호작용을 통해 프로그램이 동작하는 것을 말한다.</u>

  OOP의 특징
    - 객체지향 프로그래밍은 코드의 재사용성이 높다.
    - 코드의 변경이 용이(유지보수가 쉬움)
    - 직관적인 코드 분석
    - 개발속도 향상
    - 상속을 통한 장점 극대화

    장점
    - 코드의 재사용성이 높아 새로운 코드를 작성할 떄 기존의 코드를 이용하여 쉽게 작성할 수 있다.
    - 제어자와 method를 이용해서 데이터를 보호하고 올바른 값을 유지하도록하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지

    ###### 캡슐화
    - 중요한 데이터(변수)를 숨김(정보 은닉)
    - public method를 통해 변수에 접근
    ~~~java
        class K1{

          private int num =10; // 외부 접근 x
          protected int num2 = 20;
          String name ="kig" ; // default
          public void setNum(int num){ //캡슐화
            this.num = num;
          }
          public int getNum(){
            return num;
          }
        }

        class K2 extends K1{
          void print(){
            setNum(100);
            System.out.println(num2;
            System.out.println(getNum());
            System.out.println(name);
          }
        }
    ~~~

    ###### 상속
    - 코드 재사용

    ###### 다형성 (polymorphism)
    - 여러 가지 형태를 가질 수 있는 능력
    - 하나의 참조변수로 여러 자료형의 객체를 참조할 수 있는 것
    - 실생활 예 : 마스터키, 만능리모컨
    - 부모 클래스의 참조변수로 자식클래스의 객체를 다룰 수 있는 방법

    ###### 추상화
    - 추상클래스와 인터페이스
    - 모델의 자세한 성질은 무시하고 일반적인 성질을 나타냄
    - 객체의 공통적인 성질과 행위를 일반화하여 상위클래스를 디자인하고 자세한 성직은 하위클래스에서 구현

3. Object
    - Object(객체)는 OOP에서 `데이터(변수)` 와 그 데이터에 관련되는 `동작(함수)`, 즉 절차, 방법, 기능을 모두 포함한 개념
    - ex> 기차역에서 승차권을 발해하는 경우, 실체인 손님과 동작인 승차권 주문은 하나의 객체이며, 실체인 역무원과 동작인 승차권 발매도 하나의 객체이다.

    `clsss` : 소크 코드(설계도)
    'object' :  class의 내용을 메모리에 생성하는 것(제품)
      - 사람이라는 1개의 클래스가 있다면 10개의 객체(인스턴스)를 만들수 있음.
      `object`를 생성하기 위해서는 new 라는 연산자를 사용
      `new` 자료형 : 동적 메모리 할당

      클래스     |  객체
      ---------- | ----------
      제품 설계도 | 제품
      TV 설계도 | TV


4. Overloading vs Overriding
  `Overloading(오버로딩)` -> 상속과 관련 없음
    - 한 클래스에서 같은 이름의 method를 여러개 정의하는 것(method 중복)
    - 매개변수의 타입이 다르거나 개수가 달라야 한다.
    - 매개 변수 순서가 달라야 한다.
    - `return type`과 `접근 제어자`는 영향을 주지 않음

    ~~~java

    public class OverloadingExam{
      // 오버로드 :method 중복
      static void print(){
        System.out.println("hello");      
      }

      static void print(int a){
        System.out.println(a);      
      }

      static void print(String a){
        System.out.println(a);      
      }

      //static int print(String a){ 에러
      //  return 100;      
      //}

      /* 자료형이 중요, 변수명은 상관 없음*/
      //static void print(String b){
      //  System.out.println(a);      
      //}

      public static main void(String[] args){

        print();
        print(100);
        print("java");
      }
    }
    ~~~

    `Overriding(오버라이딩)`
      - 상속에서 나온 개념
      - 상위 클래스(부모 클래스)의 method를 하위 클래스(자식클래스)에서 상속 받은 상태에서 본문 내용만 수정하는 것(method 재정의)


      ~~~java
      public class OverrideExam{

        interface A {
          public void print();
        }
        // override : method 재정의
        class B implements A{
          public void print(){
            System.out.println("a");
            System.out.println("b");
          }
        }

        public static main void(String[] args){
          B b = new B();
          b.print();

          // 다형성  
          A a = new B();
          a.print();
        }
      }
      ~~~


      ~~~java
      Object a =10; //int
      Object a =100.5;  //double
      Object a = true; //boolean
      ~~~

      ###### 저장하는 값의 종류에 따른 변수 종류
      1. 기본자료형 (Primitive type) - 8개
      - boolean , char , byte, short, int, long, double , float
      - 실제 값을 메모리에 저장

        | 종류\크기 | 1 | 2 | 4 | 8 |
        |:----:|:----:|:----:|:----:|:----:|
        |논리형 | boolean| | | |
        |문자형| |char | | |
        |정수형 | byte| short | int | long|
        |논리형 | | |float | double |    |

      - 기본자료형은 Wrapper Class를 통해 객체로 변형할 수 있다.
        ex> int -> Integer, char -> character
        다른 자료형들은 맨 앞 알파벳을 대문자로 변경 ( float -> Float)

      2. 참조자료형(Reference type)  
      - 기본자료형을 제외한 나머지(String, System...)
      - 주소값(위치값)을 저장
      - class, interface , array 등

      3. Wrapper Class
      - Primitive type의 데이터들에 대한 다양한 method를 제공하는 클래스
      ex> 10 진수를 2 진수로 변환, 스트링을 숫자로 변환 등

      ###### AutoBox
      ~~~java
      public class AutoBox{

        public static main void(String[] args){

          // Object a = new Integer(100);
          //auto boxing
          Object a = 100;

          //auto unboxing
          System.out.println(a);          
        }
      }
      ~~~
      4. Java Collections 인터페이스
      - 컬렉션 : 집합데이터(다수의 데이터)를 의미
      - 집합데이터를 저장할 수 있는 자료형
        ex) 배열, 컬렉션 클래스 : ArrayList , HashSet , HashMap
      - 컬렉션 클래스들은 배열의 단점을 보안하기 위해 만들어짐
      - 자료 구조들에 대한 알고리즘이 미리 구현되어 있음(Stack,, LinkedList,Sort 등)
      - 자료형 발전 과정 : 변수 -> 배열 -> 구조체 -> 클래스

      ###### 배열과 컬렉션
      가. 배열의 장점 : 빠른 처리 속도
      나. 배열의 단점 : 같은 자료형만 저장 가능(Object 배열 제외) , 사이즈 고정적 , 추가 /삭제 어려움
      다. 컬렉션의 장점 : 다양한 자료형 저장 가능, 사이즈 유동적 , 추가/삭제 쉬움
      라. 컬렉션 단점 : 배열에 비해 속도가 느리고 메모리 사용량이 늘어남  

      ###### 컬렉션 종류
      ![alt text](https://3.bp.blogspot.com/-YatAN_wi-Kw/VsZujw_7XuI/AAAAAAAAAIk/5tZPcgA8T7w/s1600/%25EC%25BB%25AC%25EB%25A0%2589%25EC%2585%25981.jpg)

      ![alt text](http://cfile2.uf.tistory.com/image/235E1A44543BE051345900)


5. Servlet, JSP ,jQuery
  ###### Web Server
  - Web Client(웹 브라우저)에게 컨텐츠를 제공하는 서버
  - 정적인 <u>HTML이나 JPEG, GIF 같은 이미지</u>를 HTTP 프로토콜을 통해 브라우저에게 전송하는 역할
  - 웹 서버의 종류 : apache, IIS 등

  ###### WAS(Web Application Server)
  - Server 단에서 Web Application이 동작할 수 있도록 지원함
  - `웹 서버와 차이점` : 웹서버는 정적인 컨텐츠(html)를 지원, WAS는 동적인 컨텐츠를 지원
  - Container(컨테이너)라고도 하며, 초창기에는 CGI(Common Gateway Interface)가 많이 사용되었으며 그후에 ASP,PHP, Servlet , JSP , ASP.net등으로 발전
  - 서블릿/jsp 에 포함된 자바코드를 컴파일하여 html을 생성하여 클라이언트로 전송함
  - Client에서 요청이 들어오면 실제적인 처리는 WAS가 하고 서버는 단지 Client에 결과값을 뿌려줌
  - WAS의 종류 : tomcat , jeus , WebLogic 등

  - Servlet : 서버에서 실행되는 자바 프로그램. Servlet Container가 이해할 수 있게 구성된 순수 자바 코드로만 이루어진 것 (HTML in java)

  ###### 서블릿 실행과정
    1. 서버가 클라이언트의 연결 요청을 받음.
    2. 웹 컨테이너는 연결 요청 정보를 담고 있는 Request 객체와 연결 응답 정보를 담고 있는 Response 객체를 생성
    3. 접수된 url을 분석 후 해당 서블릿 객체를 생성하고, 사용자의 요청을 처리하기 위해 스레드를 생성 후 service() 메소드에 인자값을 담아 호출
    4. service() 메소드는 Request 객체를 참고하여 어떤 연결 요청 방식(get.post)으로 들어왔는지 파악
    5. 들어온 요청 방식에 따라 doGet(), doPost()메소드를 호출하여 처리함
    6. service() 메소드의 인자값을 넘겨받은 Response 객체를 이용하여 클라이언트에게 결과를 보여줌
    7. 사용자 요청을 처리하기 위해 생성한 스레드를 소멸.


  - JSP : HTML을 기반으로 JAVA 코드를 블록화하여 삽입한 것 (JAVA IN HTML), JVM이 설치된 OS에서도 실행 가능,정적인 페이지, 스레드를 이용해 분산처리가 가능

  ###### JSP 페이지 이동 방법
    1. Foward 방식
      - url이 바뀌지 않음, 요청객체와 응답객체가 유지됨.
      - 속도가 빠르며 요청객체에 소속 되어 있음

      - 처리 구조
      1) 요청이 들어오면 Servlet이 받음
      2) 요청에 알맞은 페이지를 찾음. 알맞은 페이지가 있다면 응답
      3) 없으면, Forwarding 방식으로 알맞은 페이지로 넘기는데 , 요청객체와 응답 객체를 포함해 넘김
      4) url이 바뀌지 않은 상태로 응답 페이지를 통해 응답.

    2. Redirect 방식
      - url이 바뀜 , 요청객체와 응답객체가 유지 되지 않음 속도가 느리며, 응답객체에 소속되어 있음.

      - 처리 구조
      1) 요청이 들어오면 Servlet이 받음
      2) 요청에 알맞은 페이지를 찾음. 알맞은 페이지가 있다면 응답
      3) 없으면, 알맞은 페이지로 다시 요청을 하게끔 응답을 보냄
      4) 클라이언트는 응답을 받고, 다시 그 요청의 맞는 url로 요청


  - jQuery : 크로스브라우징의 대안, 코드가 간결하고 css문법 지원, 스크립트 집합체        

6. JDBC(Java Data Base Connection)
  - JAVA 언어를 통해 데이터베이스에 접근할 수 있는 프로그래밍 기법을 의미

7. Get 방식 vs Post 방식
    `GET 방식` - 헤더로 데이터를 전송
    - 클라이언트에서 서버로 데이터를 전달할 때, 주소 뒤에 "이름"과 "값"(jsp?이름=값)이 결합된 스트링 형태로 전달
    - 주소창에 쿼리 스트링이 그대로 보여지기 때문에 보안성이 떨어진다.
    - 길이에 제한이 있다.( 구버전의 웹브라우저의 경우 256바이트로 제한, 최근에는 제한이 없으나 주소창으로 대량의 데이터를 보내는 것은 적합하지 않음)
    - `Post방식` 보다 상대적으로 전송 속도가 빠르다.

    `POST 방식` - body에 데이터 전송
    - 대량의 데이터를 보내야 할 때 사용한다.(파일 업로드)
    - 서버로 보내기 전에 인코딩하고, 전송 후 서버에서는 다시 디코딩 작업을 한다.
    - 주소창에 전송하는 데이터의 정보가 노출되지 않아 GET 방식에 비해 보안성이 높다.
    - 속도가 Get방식보다 느리다.
    - 쿼리스트링(문자열) 데이터 뿐만아니라, 라디오 버튼, 텍스트 박스, 첨부파일의 값도 전송가능
    - <u>tcp/ip 모니터로 확인 가능</u>

    ~~~html
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@ include file="../include/header.jsp" %>
    </head>
    <body>
    <h2>회원등록</h2>
    <%@ include file="../include/menu.jsp" %>
    <form action="${path}/member/insert.do" method="post" name="form1">
    	<table>
    		<tr>
    			<td>아이디</td>
    			<td><input name="userid"></td>
    		</tr>
    		<tr>
    			<td>비밀번호</td>
    			<td><input tyep="password" name="passwd"></td>
    		</tr>
    		<tr>
    			<td>이름</td>
    			<td><input name="name"></td>
    		</tr>
    		<tr>
    			<td>email</td>
    			<td><input type="email" name="email"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    			<input type="submit" value="확인"> </td>
    		</tr>

    	</table>

    </form>
    </body>
    </html>
    ~~~

    `Get방식과 Post방식의 차이점`
    - Get방식은 주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용(검색, 리스트)
    - Post방식은 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용(회원가입, 로그인 정보)
    - Get을 사용하면 웹 브라우저에서 웹 서버로 전달되는 데이터가 인코딩되어 URL에 붙는다.
    - Post방식은 전달되는 데이터가 보이지 않는다.
    - 웹서버에 많은 데이터를 전달하기 위해서는 Post 방식을 사용하는 것이 바람직(파일 첨부의 경우는 반드시 post 방식)

8. Session 과 Cookie
  사용 이유?
  - HTTP프로토콜은 `비연결 지향적`으로 새로운 페이지를 요청할 때마다 새로운 접속이 이루어지며 이전 페이지와 현재 페이지 간의 관계가 지속되지 않는다. 이에 따라 HTTP프로토콜을 이용하게 되는 웹사이트에서는 웹페이지에 특정 방문자가 머무르고 있는 동안에 그 방문자의 상태를 지속시키기 위해 쿠키와 세션을 이용한다.

  `Session`
  - 일정 시간동안 같은 사용자로 부터 들어오는 일련의 요구를 하나의 상태로 보고 그 상태를 일정하게 유지시키는 기술
  - 특정 웹사이트에서 사용자가 머무는 기간 또는 한 명의 사용자의 한번의 방문을 의미
  - `Session에 관련된 데이터는 Server에 저장된다.`(쿠키보다 안전)
  - 웹 브라우저의 캐시에 저장되어 브라우저가 닫히거나 서버에서 삭제시, 사라진다.
  - Cookie에 비해 보안성이 좋다.
  - 모든 정보를 Session에 저장하면 Server의 메모리를 과도하게 사용하게 되어 Server에 무리가 감
    (동시 접속자가 만명이면 서버는 만명의 사용자 정보를 저장---> 메모리 터질듯,,)
  - 서버의 성능 저하 발생 가능성 있음  

  `Cookie`
  - 인터넷 웹 사이트의 방문 기록을 남겨 사용자와 웹 사이트 사이를 매개해주는 정보
  - `Cookie`는 인터넷 사용자가 특정 웹 서버에 접속할 때, 생성되는 개인 아이디와 비밀번호 등의 방문한 사이트의 정보를 담은 `임시 파일`로써, Server가 아닌 Client에 텍스트 파일로 저장되어 다음에 해당 웹서버를 방문할 경우 웹서에서는 그가 누구인지 어떤 정보를 주로 찾았는지 등을 파악할 때 사용된다.
  - `Cookie`는 *Client PC*에 저장되는 정보이기 때문에 다른 사용자에 의해서 임의로 변경이 가능하다.( 정보 유출 가능 up, Session보다 보안성이 낮은 이유)
  - 복잡한 코드 작성

9. MVC 패턴
  - MVC 패턴은 코드의 재사용성이 유용하며, 사용자 인터페이스와 응용프로그램 개발에 소요되는 현저하게 줄여주는 형식이라고 많은 개발자들이 평가

  ###### MVC 이미지
  ![alt text](https://mblogthumb-phinf.pstatic.net/MjAxNzAzMjVfMjUw/MDAxNDkwNDM4NzI4MTIy.4ZtITJJKJW_Nj1gKST0BhKMAzqmMaYIj9PobYJMFD4Ig.xTHT-0qyRKXsA4nZ2xKPNeCxeU2-tLIc-4oyrWq5WBgg.PNG.jhc9639/mvc_role_diagram.png?type=w800)


  ###### MVC 구성요소
  - Model : 소프트웨어 응용과 그와 관련된 고급 클래스 내의 논리적 데이터기반 구조를 표현(dto.dao) , 즉 데이터 이자 비지니스 로직
  - View : 사용자 인터페이스 내의 구성요소들을 표현(사용자에게 보여지는 화면)
  - Controller : Model과 View를 연결하고 흐름을 제어하는 클래스. Model과 View 사이의 정보를 교환하는데 사용


  ###### MVC 패턴의 장점
  - 로직과 데이터 등 어플리케이션을 세부분으로 분리함으로써 더 이해하기 쉽고 의존성이 낮아짐
  - 디자이너 개발자의 협업을 위해서 사용
  - 로직에 전혀 영향을 주지 않고 화면 표시를 수정

  ###### Model1,2 차이점
  ![alt text](http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile10.uf.tistory.com%2Fimage%2F99A907335A1BAF5810CE95)
  `model1`  
  - 사용자의 요청을 jsp가 전부 처리, 웹 브라우저 사용자의 요청을 받은 jsp는 자바빈이나 서비스 클래스를 사용하여 웹 브라우저가 요청한 작업을 처리하고 그 결과를 출력.
  - 디자인 코드와 자바 코드를 구분하지 않고 하나의 jsp 내에 작성

  - 특징
    1. 개발하기 쉽고 배우기 쉽다.
    2. 복잡하고 협업하기 힘듬

  ![alt text](http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile8.uf.tistory.com%2Fimage%2F995D11335A1BB0C603986E)

  `model2`
  - mvc 패턴 사용, 사용자의 요청을 서블릿이 받아, 서블릿은 요청을 받아 view로 보여줄것인지 model로 보내줄것인지 정하여 전송합니다. HTML과 java 소스를 분리 해놓았기 때문에 모델1방식에 비해 개발을 확상시키고 유지보수하기 쉽다.


10. Interface . Abstract
  interface
  - 오직 `추상 메서드`와 `상수`만을 멤버로 갖는다.
    (jdk 1.8부터는 static method와 defalt method도 가능)
  - static method : 인터페이스를 구현한 클래스에서 오버라이드할 수 없음.
  - default method : 기존 인터페이스에 새로운 method를 추가하게 되면 인터페이스를 구현한 모든
  클래스들의 코드가 변경되어야 함. 이 때 default 키워드를 붙이면 선택적으로 method를 구현하게 할 수 있다.

~~~java
  public interface Test{
    public static void methodA(){
      System.out.println("test");
    }
    public default void methodB(){
        // 구현 내용(선택적으로 override가 가능함)
    }
  }

  class TestA implements Test{

    @Override
    public void methodB(){

    }
  }
~~~
  - `implements` 키워드 사용
  - 상속 관계가 없는 클래스가 서로 공통되는 로직을 구현하려 쓸 수 있도록 한다.
  - `extends`는 하나의 클래스만 상속 가능, `implements`는 다중 구현이 가능하다.
  - 다중상속 금지 이유 : 구조가 복잡해지기 때문에

  Abstract class(추상 클래스)
  - 추상method를 하나 이상 가진 클래스
  - 자신의 생성자로 객체 생성 불가능
  - 하귀 클래스를 참조하여 상위 클래스의 객체를 생성
  - 상위 클래스의 자료형으로 하위 클래스를 제어하기 위해 사용

  Interface vs Abstract 공통점
  - `new` 연산자로 인스턴스 생성 불가능
  - 프로토타입(미완성 버전, 시스템의 초기 모델)만 있는 method를 갖음
  - 사용하기 위해서는 하위클래스에서 확장/구현 해야함

  Interface vs Abstract 차이점
  - 사용하는 키워드가 다르다.
  - Abstract는 완성된 method를 사용할 수 있지만, Interface는 추상 method와 static, default method 선언만 가능하다.

  ~~~JAVA

  interface AAA{
    public void a(); // 추상 method
    public static void b(){ // static method
      System.out.println("b");
    }
    public default void c(){ //default method
      System.out.println("c");
    }
  }

  public class InterfaceEXA implements AAA{

    @Override
    public void a(){
      System.out.println("a print");
    }
    public void b(){
      System.out.println("b print");
    }
    public void c(){
      System.out.println("c print");
    }

    public void static main(String args[]){
      InterfaceEXA ex = new InterfaceEXA();
      ex.a(); // a print
      AAA.b(); // b
      ex.b(); // b print
      ex.c();  // c print
    }
  }

  ~~~
11. Call by Reference / Call by value
  Call by Reference - 매게 변수의 원래 주소에 값을 지정하는 방식. 클래스 객체를 인수로 전달하는 경우
  Call by value - 인수로 기본 데이터형을 사용. 주어진 값을 복사하여 처리하는 방식. method 내의 처리 결과는 method 밖의 변수에 영향을 미치지 않는다.

  ~~~JAVA
  public class CallBy{

    static void print(int a){
      // call by value(값에 의한 호출)
      a=20;
      System.out.println(a);
    }

    //class by reference(address) , 주소값에 의한 호출
    static void print(int[] a){ // 참조 변수만 copy
      a[0]=100;
      for(int n:a){
        System.out.print(n);
      }
    }

    public static void main(String args[]){
      int a = 10;
      int[] arr ={10,20,30,40,50};
      print(a); //20
      System.out.print(a); // 10
      print(arr); // 100,20,30...
      System.out.println();
      for(int n:arr){
        System.out.print(n); // 100,20,30...
      }
    }
  }
  ~~~

  ###### Method 호출(call)
  ~~~JAVA
  public static void main(String args[]){
    statement;
    method1();
    statement;
    method2();
    statement;
  }
  ~~~
  Call by value
  ~~~java
  public void meth(int num){}
  int a = 34;
  meth(a);
  ~~~
  메모리 2개 생성
  a |num
  --|--
  34|34

  Call by reference
  ~~~java
  public void meth(Number num){}
  Number a = new Number(34);
  meth(a);
  ~~~
   참조변수 2개
  a -----> the actual object <----- num  

12. static의 의미
  - 클래스가 로딩될 때, 메모리 공간을 할당하는데 처음 설정된 메모리 공간이 변하지 않음을 의미
  - 객체를 아무리 많이 만들어도 해당 변수는 하나만 존재(객체와 무관한 키워드)

  1) static - 정적인 상태 (<--> *dynamic*)
  2) static member - static variable (정적 변수) , 어디서든 공유해서 사용할 수 있는 변수
  3) static member의 특징
    - 프로그램이 실행되면 메모리(클래스 영역)에 자동으로 로딩됨
    - 프로그램이 끝날 때까지 메모리에 상주
    - `static method`에서는 static member만 사용 가능
    ~~~java
    public class StaticExam{
      static int a = 100;
      int b=200;
      static void printA(){
        System.out.println(a); // static 멤버만 사용 가능
      }
      void printB(){
        System.out.println(a);
        System.out.println(b);
      }

      public static void main(String args[]){
        printA();
        StaticExam ex = new StaticExam();
        ex.printB();
      }
    }
    ~~~
  4) dynamic member의 특징
    - 프로그램 실행 중에 필요할 때 만들어지고 필요 없으면 삭제됨
    stack, heap 영역에 저장됨

##### JAVA 실행 구조
![alt text](http://cfile7.uf.tistory.com/image/03289A4B51A455601F4C48)    

##### JVM MEMORY
  ![alt text](http://cfile27.uf.tistory.com/image/0139C94D51A4557F390D7A)

  1) Java Source : 사용자가 작성한 java code
  2) Java Compiler :java code를 byte code로 변환
  3) Class Loader : 클래스의 내용을 메모리(Runtime Data Area)에 로딩하는 기능
  4) Execution Engine : 바이트코드로 해석 기능
  5) Runtime Data Area : 운영체제에서 할당받는 메모리 공간
      1. Class 영역 : method, code, static
      2. Stack 영역 : method 호출 , 지역 변수 생성/삭제, 리턴 값 및 연산시 일어나는 값을 임시 저장
      3. Heap 영역 : new 연산자로 생선된 객체와 배열(동적 메모리 할당), 대용량 메모리, 클래스 영역에 로드된 클래스만 생성, Garbage Collector를 통해 메모리 반환, 인스턴스 , 배열
      4. Native 영역 : 자바외의 다른 언어에서 제공되는 메서드 저장, JNI(c 언어 코드 호출),c언어 함수 공간
      5. PC 레지스터 : Thread가 생성 될때 마다 생성되는 공간, 즉 현재 실행중인 부분의 명령어와 주소가 저장

  String str = new String("hello");
  Stack | Heap
  ------|------
  str   | new String("hello")


13. FRAMEWORK
 - 특정 형태의 소프트웨어 문제를 해결하기 위해 상호 협력하는 클래스프레임과 인터페이스 프레임의 집합
 - 특정한 틀을 만들어놓고 거기에 살을 붙여 놓음으로써 작업시간을 줄여준다.
 - `프레임워크가 중요한 이유`: 객체지향 개발을 하게 되면서 개발자의 취향에 따라 다양한 프로그램이 나오게 되었다.

 - 프레임워크는 특정 개념들의 추상화를 제공하는 여러 클래스나 컴포넌트로 구성된다.
 - 프레임워크는 이렇게 추상적인 개념들의 문제를 해결하기 위해 같이 작업하는 방법을 정의
 - 프레임워크 컴포넌트들은 재사용이 가능하다
 - 프레임워크는 좀 더 높은 수준에서 패턴을 조작한다.

 - 프레임워크가 가져야할 특징
    1. 개발자들이 따라야 할 가이드라인을 가진다.
    2. 개발할 수 있는 범위가 정해져 있다.
    3. 개발자를 위한 다양한 도구들이 지원
 - `프레임워크의 장/단점`
    장점 : 개발 시간을 줄일 수 있고 오류로부터 자유로울 수 있다.
    단점 : 프레임워크에 너무 의존하면 개발 능력이 떨어져서 프레임워크 없이 개발하는 것이 불가능해질 수 있다.

14. Garbage Collection
 - 시스템에서 더이상 사용하지 않는 동적 할당된 메모리 블럭을 찾아 자동으로 다시 사용 가능한 자원으로 회수하는 것으로 시스템에서 가비지컬렌션을 수행하는 부분을 `가비지 컬렉터`라 부른다.
 http://itmining.tistory.com/24

15. Spring Framework
  - 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크
  - 자바 엔터프라이즈 개발을 편하게 해주는 오픈 소스 경량급 애플리케이션
  - 자바 개발을 위한 프레임워크로 종속 객체를 생성해주고 조립해주는 도구
  - Java SE로 개발된 자바 객체(POJO)를 Java EE에 의존적이지 않게 연결해주는 역할을 담당
  - java 엔터프라이즈 애플리케이션 개발에 사용 되는 애플리케이션 프레임워크로 개발을 빠르고 효율적으로 할 수 있도록 애플리케이션의 바탕이 되는 틀과 공통 프로그래밍 모델, api 제공

  ##### 스프링의 특징
  - 크기와 부하의 측면에서 경량
  - 의존관계 주입(DI)와 제어 역행(IoC) 기술을 통해 애플리케이션의 느슨한 결합을 도모
    ###### POJO : 별도의 API가 필요하지 않은 일반적인 자바 코드
    ###### IoC  : 객체에 대한 제어권
      - 기존에는 개발자에게 제어권이 있었음 (new 연산자)
      - 객체의 제어권을 스프링에게 넘김
      - 인스턴스의 라이프 사이클을 개발자가 아닌 스프링이 담당
                      사용
      클래스 -----------------------------> 인터페이스
        ^                                      ^
        |                                      |   
        | 의존성삽입                            | 구현
        |             생성                      |
      조립기 -----------------------------> 구현클래스

      실행 시점에 외부 조립기에 의해서 클래스간의 의존관계가 형성됨
    ###### DI(Dependency Injection) : 의존관계 주입
      - 객체 간의 의존성을 개발자가 설정하는 것이 하닌 스프링 컨테이너가 주입 시켜주는 기능
      - 객체를 쉽게 확장하고 재사용할 수 있음  
  - 관점지향 프로그래밍(AOP)를 위한 풍부한 지원 : 반복적인 코드를 줄이고 개발자가 비즈니스 로직에만 집중할 수 있도록 지원
    ###### AOP( Aspect Oriented Programming) : 관점지향적인 프로그래밍
    - OOP를 보완하는 확장적인 개념
    - Aspect: 핵심적인 비지니스 로직은 아니지만 반드시 해야하는 작업, 공통 관심사
      (횡단로직 : 로깅, 트랜잭션, 보안처리)
    - 관심의 분리를 통해 핵심관점(업무로직)+ 횡단관점으로 관심의 분리 실현
    - 장점 : 중복되는 코드 제거 , 효율적인 유지 보수 , 높은 생산성, 재활용성 극대화
    - AOP의 주요 용어
      - Join Point : method를 호출하는 시점, 예외가 발생하는 시점 등과 같이 특정 작업이 실행되는 시점 의미

      ![alt text](http://postfiles6.naver.net/20140627_149/platinasnow_1403836406321rAl0L_PNG/Untitled-1.png?type=w2)
      - Adivice : Join Points에서 실행되어야 하는 코드
        - Before : target method호출 전에 적용
        - After : target method 호출 후에 적용
        - Around : target method 호출 이전과 이후 모두 적용
      - Pointcuts : 실재로 Advice를 적용시길 대상 method
      - Proxy : Advice가 적용되었을 때 만들어지는 객체  
  - 애플리케이션 객체의 생명주기와 설정을 포함하고 관리한다는 점에서 일종의 컨테이너
  - 간단한 컴포넌트로 복잡한 애플리케이션
  - WAS에 종속적이지 않은 개발 환경
  - MVC 구조
  - EJB 기능을 대체할 수 있고 트랜잭션 처리를 위한 일관된 방법을 제공
  - 영속객체 => DAO
  - 영속석과 관련된 다양한 서비스를 지원
    mybatis 나 hibernate 등 이미 완성도가 높은 데이터베이스 처리 라이브러리와 연결할 수 있는 인터페이스를 제공한다.

    ###### hibernate
    가. 객체 관계 매핑(Object-relational mapping; ORM)
      데이터베이스와 객체 지향 프로그래밍 언어 간의 호환되지 않는 데이터를 변환하는 프로그래밍 기법
    나. ORM 종류 : hibernate, mybatis(ibatis)  
    다. hibernate
      1) 자바 언어를 위한 객체 관계 매핑 프레임워크
      2) 객체 지향 도메인 모델을 관계형 데이터베이스로 매핑하기 위한 프레임워크를 제공

    라. 실행 순서
        1. 자바 코드 내에서 특정 쿼리문을 실행하기 원할 때, 파라미터와 필요한 조건을 넘기기 위한 객체를 생성(SqlSession sqlSession)
        2. SQL Mapper를 실행하기 위해서는 쿼리의 id로 호출
        3. 쿼리가 실행되었을 때 SQL Mapper는 쿼리의 결과를 받기 위해 정의된 클래스의 인스턴스를 생성
        4. 인스턴스는 데이터베이스에 의해 반한된 ResultSet으로부터 만들어짐


  - 확장성이 높다. : 스프링 프레임워크에 통합하기 위해 기존 라이브러리를 쉽게 추가하거나 별도로 분리하기에 용이하다.  *maven*

  - `실행순서`
    1) web.xml에 등록된 DispatchterServlet을 통해서 요청에 대해 진입.
    2) DispatchterServlet은 Client로 부터 들어온 URL을 HandlerMapping이라는 곳으로 전송 후,
    URL을 분석해서 알맞은 Controller 이름 다 DispatchterServlet으로 보냄
    3) HandlerMapping을 통해서 실행될 Controller의 이름을 입력받은 DispatchterServlet은 전달받은 Controller는 스프링에서 제공하는 ModelAndView 객체에 뷰 페이지에 전달할 객체와 View Page 이름 정보를 담고 DispatchterServlet으로 보냄
    4) ViewResolver를 통해 보여질 View페이지를 탐색한 후, View페이지를 보여줌

    http://localhost/Spring/list.do
    web.xml : 웹프로젝트의 배치 기술
    root-context.xml : 서블릿 이외의 설정 , DB 설정 , 트랜잭션
    servlet-context.xml : 서블릿에 관련된 설정 , 리소스 매핑(정적인 컨텐츠), 뷰 리설버 , 컨트롤러 , 서비스 빈 자동 등록, 파일 업로드 관련 설정 ,aop
    스프링에 내장된 DispatchterServlets는 디폴트 서블릿으로 설정

16. Thread
  - 프로세스 내에서 동시에 실행되는 독립적인 실행 단위
  - 자원을 많이 사용하지 않고 구현이 쉬우며 범용성이 높다.
  - `장점` : 빠른 프로세스 생성, 적은 메모리 사용 , 쉬운 정보 공유
  - `단점` : 교착상태에 빠질 수 있다.
  - 프로세스 안에서 동작하며 Code, Data, Heap 영역을 공유하고 별도의 Stack만 가지고 있다.
  - Context switching시 Stack영역만 switching하면 되므로 프로세스 스위칭 보다 빠르다.
  - 쓰레드 간 자원 공유가 가능하여 편리하지만 자원 동기화의 문제가 있다.

  ###### Process
  - 운영체제에서 실행중인 하나의 프로그램
  - Code, Data, Heap, Stack 영역으로 이루어져 있다.
  - 각각의 Memory space를 차지한다.

  ###### Process와 Thread의 관계
  ![alt text](http://cfile28.uf.tistory.com/image/214CF735590C5E90161768)

  ###### Thread 구현 방법

 1. 쓰레드 클래스 상속하기 (다른 클래스를 상속받을 수 없다.)
  ~~~java
  public class ThreadEx extends Thread {
  	@Override
  	public void run() { // Thread 코드
  	}

  	public static void main(String[] args) {

  		new ThreadEx().start(); // 쓰레드 시작 .start();
  	}
  }
  ~~~

 2. Runnable 인터페이스 구현하기 (재사용성이 높으며, 일관성 유지가능)


  ~~~java
  public class ThreadEx implements Runnable {

  	@Override
  	public void run() { // Thread 코드
  	}

  	public static void main(String[] args) {

  		ThreadEx tEx = new ThreadEx();
  		Thread t = new Thread(tEx); // 쓰레드 구현
  		t.start();// run 메서드 호출

  	}
  }
  ~~~

  ###### Thread 호출 순서
  ![alt text](http://cfile21.uf.tistory.com/image/2431B74F5964517D32A773)

  - 스레드의 상태 6가지
① NEW : 스레드가 생성되었지만 스레드가 아직 실행할 준비가 되지 않았음
② RUNNABLE : 스레드가 실행되고 있거나 실행준비되어 스케쥴링은 기달리는 상태
③ WAITING : 다른 스레드가 notify(), notifyAll()을 불러주기 기다리고 있는 상태(동기화)
④ TIMED_WAITING : 스레드가 sleep(n) 호출로 인해 n 밀리초동안 잠을 자고 있는 상태
⑤ BLOCK : 스레드가 I/O 작업을 요청하면 자동으로 스레드를 BLOCK 상태로 만든다.
⑥ TERMINATED : 스레드가 종료한 상태

  ###### Thread 우선순위
  - 2개 이상의 스레드가 동작 중일 때 우선 순위를 부여하여 우선 순위가 높은 스레드에게 실행의 우선권을 부여할 수 있습니다.

  - 우선 순위를 지정하기 위한 상수를 제공
  - `static final int MAX_PRIORITY` : 우선순위 10 - 가장 높은 우선 순위
  - `static final int MIN_PRIORITY`  :  우선순위 1 - 가장 낮은 우선 순위
  - `static final int NORM_PRIORITY` : 우선순위 5 - 보통의 우선 순위

  - 스레드 우선 순위는 변경 가능
      - void setPriority(int priority)
      - int getPriority()


  - main()스레드의 우선 순위 값은 초기값 : 5

  - JVM의 스케쥴링 규칙
    - 철저한 우선 순위 기반
    - 가장 높은 우선 순위의 스레드가 우선적으로 스케쥴링
    - 동일한 우선 순위의 스레드는 돌아가면서 스케쥴링(라운드 로빈)

    ~~~java
    public class PriorityTest extends Thread
    {
        // 출력생성자
        PriorityTest(String str)
        {
            super(str);
        }

        public void run()
        {
            try
            {
                // 각각 1초 간격으로 스레드
                for(int i = 0 ; i < 10 ; i++)
                {
                    Thread.sleep(1000);
                    System.out.println(getName() + i + "번째 수행");
                }
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    ~~~

    ~~~JAVA
    public class Thread
    {
      public static void main(String args[])
      {
          PriorityTest t1 = new PriorityTest("우선 순위가 낮은 스레드");
          PriorityTest t2 = new PriorityTest("우선 순위가 높은 스레드");
          t1.setPriority(Thread.MIN_PRIORITY);    // 최소 우선 순위 지정
          t2.setPriority(Thread.MAX_PRIORITY);    // 최대 우선 순위 지정
             t1.start();
          t2.start();
      }
    }
    ~~~

  ###### Multi Thread

   ![alt text](http://cfile23.uf.tistory.com/image/26EA58335965C8921CDF7B)
  - 두 가지 이상의 작업을 동시에 실행할 수 있어 자원을 효율적으로 이용할 수 있으나 `동기화` 및 `Deadlock`에 대한 검증 필요
  - `장점`
    - 자원을 보다 효율적으로 사용
    - 사용자에 대한 `응답성` 향상
    - 작업이 분리되어 코드 간결
  - `단점`
    - 동기화, 교착상태 주의
    - 각 스레드가 효율적으로 고르게 실행될 수 있게 해야 함  
  - 여러 개의 스레드가 동시에 수행되면서 공유할 수 있을때
  - 공유되는 부분은 상호 배타적으로 사용되어야 합니다.
    - Dead Lock 문제
      - 멀티 스레드를 사용할 때 주의할 점중의 하나로 프로그램에서 스레드를 잘못 만들면 프로그램의 수행이 이루어 지지 않고 무한 수행하는 Dead Lock을 만들 수 있습니다.
    - 임계 영역(critical section)
      - 공유 자원을 사용하는 코드영역을 임계영역이라 합니다.
      - 이 부분에서는 공유 자원을 동시에 수정할 수 없도록 상호 배타적으로 실행될 수 있도록 작성되어야 합니다.

  - 자바에서 상호배제 문제를 해결하는 방법
    - 자바는 한 순간에 하나의 스레드만 실행할 수 있는 synchronized method 제공
    - 한 스레드가 synchronized method를 수행 중이면 다른 스레드는 대기합니다.

  - 처리방법
    - 공유 자원에 접근하는 메소드의 앞에 synchronized 메소드로 지정 합니다.
    - 공유 자원을 사용하는 영역을 synchronized(객체명)의 블록으로 지정합니다.


  ###### 스레드 동기화
  ■ 동기화란?

  한 마디로 작업들 사이의 수행 시기를 맞추는 것 입니다. 멀티 스레드 환경에서 하나의 객체를 사용할 때를 예시로 들어보겠습니다.
  ![alt text](http://cfile26.uf.tistory.com/image/226163435792DCAB1183D8)

  두 스레드가 하나의 Object 객체의 data에 접근하는 경우 입니다. 만약 위의 두 스레드를 동시에 실행했을때 1이 data에 5를 넣고 출력하는 사이에 Thread2가 data를 10으로 바꿔버린다면 Thread1에서는 5가 아닌 10이 출력되는 문제가 발생할 수 있습니다.



  이처럼 하나의 데이터에 여러곳에서 접근하게 될때 데이터의 일관성에 문제가 생기는것을 방지하기 위해서 스레드 동기화를 하게 됩니다. 위의 경우에 스레드 동기화를 하게 되면 Thread1이 작업중일때는 Thread2가 data를 건드릴 수 없고, Thread2가 작업중일 때는 Thread1이 data를 건드릴 수 없게 됩니다.


  ■ 스레드 동기화 기법의 종류

  스레드 동기화 기법은 유저 모드 동기화와 커널 모드 동기화 두 가지로 나뉘게 됩니다.


  ◆ `유저모드 동기화`

  유저 모드 동기화(Synchronization in User Mode)에는 Critical Section(임계 영역) Object를 사용하고 커널 모드 동기화에 비해 빠르다는 장점이 있습니다. 커널모드는 연산 모드를 유저모드에서 커널모드로 변경해야 하기 때문에 상대적으로 유저 모드 동기화보다 느리지만 유저모드 동기화는 유저 모드에서 동기화가 이루어지기 때문에 모드 전환에 대한 부담이 없습니다. 하지만 단일 프로세스 내의 스레드 간의 동기화만 제공되는 등의 기능이 제한되고, Deadlock(교착상태)이 발생하기 쉽습니다.


  ◆ `커널모드 동기화`

  커널 모드 동기화(Synchronization in Kernel)는 Mutex, Event, Semaphore Object를 사용하며 커널에 의해 공유되기 때문에 다른 프로세스에 존재하는 쓰레드들 간의 동기화가 가능합니다. 또, Deadlock을 방지하기 위해 타임 아웃을 설정할 수 있습니다. 하지만 연산 모드를 변경하기 때문에 유저모드보다 상대적으로 느릴 수 있는 단점이 있습니다.

  1) 임계구역
  ~~~java
        synchronized (java.lang.Object.class) {
            System.out.println("----------Start Working!----------");
            for(int i =0;i<100000000;i++){
            System.out.println(i);
            }
            System.out.println("----------Finish Working!----------");
        }
  ~~~      

  java.lang.Object는 하나 이므로 위의 코드처럼 java.lang.Object를 기준으로 동기화를 할 수 있습니다. Start Working!이 출력된 뒤 Finish Working!이 출력되어 작업이 끝나기 전까지 다른 스레드들은 작업을 수행하지 않고 기다리게 됩니다.

  2) 메소드
  ~~~java
    public synchronized void doWork(){
        System.out.println("----------Start Working!----------");
        for(int i =0;i<100000000;i++){
        System.out.println(i);
        }
        System.out.println("----------Finish Working!----------");
    }
  ~~~
  위의 코드는 메소드 자체를 동기화 시키는 코드 입니다. 여러 스레드가 doWork()메소드를 호출하더라도 한번에 한 개의 메소드만 작동되게 됩니다. 위의 경우 인스턴스 메소드이기 때문에 자신의 객체를 기준으로 동기화하고, Static 메소드일 경우 자신의 클래스를 기준으로 동기화하게 됩니다.

17. 접급 제어자 (public > protected > default > private)
    public : 접근 제한이 없다. ( 같은 프로젝트 내에 어디서든 사용 가능 )
    protected : 같은 패키지 + 다른 패키지의 경우 자손 클래스에서 접근 가능
    default : 같은 패키지 내에서만 접근 가능
    private : 클래스 내부에서만 사용 가능(외부 클래스에서 접근 불가능)


18. 소켓 통신(TCP/UDP)
  ![alt text](https://i.pinimg.com/originals/54/26/7c/54267c208f829d18d3da68aa30976d26.jpg)

  `TCP(Transmission Control Protocol)`
  - 연결형 서비스 제공
  - 데이터의 수신 여부를 확인(오류시 재전송 요청)
  - 높은 신뢰성 보장

  `UDP(User Datagram Protocol)`
  - 비연결형 서비스 제공
  - 신뢰성이 낮고 데이터의 전송 순서가 바뀔 수 있음
  - TCP보다 전송속도가 빠름
  - 동영상 및 음성 등의 멀티미디어 통신에 주로 사용됨

  ![alt text](http://cfile29.uf.tistory.com/image/214A0940565D29031F2BF4)

19. Stack / Queue

  ###### Stack
  - LIFO(Last in Frist Out) : 후입선출 구조
  - push()를 이용한 데이터 입력 , pop()을 이용한 데이터 출력
  - ex) 시스템 스택 : 함수의 호출과 복귀 순서는 스택의 구조를 응용하여 관리
  - 역순 문자열 , 수식의 괄호 검사 등

  ![alt text](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png)

  ###### Queue
  - FIFO(First In First Out) : 선입선출 구조
  - enQueue()를 이용한 데이터 입력, deQueue()를 이용한 데이터 출력
  - ex) 우선순위가 필요한 작업 예약(인쇄 대기열)
  ![alt text](https://www.cs.cmu.edu/~mrmiller/15-121/Homework/hw8/queue.png)
  - Linear Queue(선형큐)는 메모리 재사용이 불가능 이러한 문제점을 보안하여 Circlar Queue(원형 큐)가 나옴
  ![alt text](http://cfile26.uf.tistory.com/image/993DE43359A28383032157)

20. Sigleton Design Pattern
  - 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.
  - 애플리케이션 전체에서 단 하나의 인스턴스만을 생성하도록 제한함
  - 생성자를 `private`으로 설정하여 외부에서 직접 인스턴스 생성 불가
  - 전역적으로 1개의 인스턴스에 접근 가능한 method 제공
  - 싱클톤 패턴이 적용되는 경우
    ex) 도서관리대장 - 100권의 도서가 있어도 관리대장은 1권만 필요
  ![alt text](http://cfile9.uf.tistory.com/image/2243663456C098EE3424A9)  

    ###### java code
    ~~~java
      public class Singleton{

    	// 인스턴스를 저장하기 위한 변수
    	// 외부에서 직접 호출할 수 없도록 private으로 선언
    	private static Singleton uniqueInstance;

    	//생성자도 private으로 선언하여 외부에서 호출할 수 없도록 함
    	private Singleton(){}

    	//클래스의 유일한 인스턴스를 반환하는 메서드
    	public static Singleton getInstance(){
    		//인스턴스가 존재하지 않는다면 생성
    		if(uniqueInstance == null){
    			uniqueInstance = new Singleton();
    		}
    		return uniqueInstance;
    	}

    }
    ~~~  


21. 객체의 직렬화(Serialization)

  `직렬화`
  - 객체를 파일로 저장하거나 네트워크를 통해 전달하기 위해 데이터 스트림으로 변환하는 작업객체에 <u>저장된 데이터를 스트림에 쓰기 위해 연속(Serial)적인 데이터로 변환</u>하는 것을 말함
  - 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술

  `역직렬화`
  - 바이트로 변환된 데이터를 다시 객체로 변환하는 기술
  - 스트림으로부터 데이터를 읽어서 객체로 만드는 것

  시스템적으로 이야기하자면 JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환하는 기술과 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 같이 이야기합니다.

  `직렬화의 장점` : 객제 내용을 입출력형식에 구해받지 않고 객체를 파일에 저장함으로써 영속성을 제공객체를 네트워크를 통해 손쉽게 교환이 가능한다.

  `직렬화 사용이유?`
   1. RMI(Remote Method Invocation)
      - RMI는 원격객체통신을 지원해야 하기때문에 객체가 그대로 이동해야대는데 이를위해 직렬화가 필요하다

   2. Beans
      - Beans는 설계시 상태정보를 지정할수 있는데 이때 객체직렬화를 사용하여 편하게 객체의 상태정보를 저장

  `직렬화 구현 방법`    
  - 'java.io.Serializable' 인터페이스 구현
  - 직렬하고자 하는 객체의 클래스에 직렬화가 안된 객체 또는 비밀번호과 같이 숨기고 싶은 정보가 있다면 제어자 transient를 붙여서 직렬화 대상에서 제외할수 있음

  ~~~JAVA
    package example;

    import java.io.Serializable;
    //객체직렬화 하기 위해서는 Serializable 인터페이스 구현해야 함
    public class MemberDTO implements Serializable{
    	private String name;
    	private int age;

  	// transient 객체직렬화에서 제외하고 싶은 요소
  	private transient MemberInfoDTO memberInfo;

  	//기본 생성자, 매개변수가 있는 생성자
  	public MemberDTO() {

  	}
  	public MemberDTO(String name, int age
  			,String jumin, String pwd) {
  		super();
  		this.name = name;
  		this.age = age;
  		memberInfo = new MemberInfoDTO(jumin,pwd);
  	}
  	public String getName() {
  		return name;
  	}
  	public void setName(String name) {
  		this.name = name;
  	}
  	public int getAge() {
  		return age;
  	}
  	public void setAge(int age) {
  		this.age = age;
  	}
  	public MemberInfoDTO getMemberInfo() {
  		return memberInfo;
  	}
  	public void setMemberInfo(MemberInfoDTO memberInfo) {
  		this.memberInfo = memberInfo;
  	}
  	@Override
  	public String toString() {
  		return "MemberDTO [name=" + name + ", age=" + age + "]";
  	}


  }

  ~~~

  ~~~JAVA
  import java.io.FileInputStream;

  public class ObjectStreamExam{
    //Stream : 데이터의 논리적인 통로, 바이트 단위
    // 프로그램 <============> 외부자원 : 출력스트림
    // 프로그램 <============> 외부자원 : 입력스트림

    public static void main(String[] args){
      FileOutStream fos = null;
      ObjectOutputStream oos = null; // 객체 직렬화 클래스

      //객체 3개 생성
      MemberDTO m1 = new Member("kim",30,"870711-1111111","1234");
      MemberDTO m2 = new Member("park",32,"870711-1111111","1234");
      MemberDTO m3 = new Member("hong",34,"870711-1111111","1234");

      try{
        // 파일 저장을 위한 출력 스트림
        fos = new FileOutStream("d:\\object.dat");

        // 메모리에 있는 객체를 파일로 저장하기 위한 스트림  
        oos = new ObjectOutputStream(fos);
        oos.writeObject(m1);
        oos.writeObject(m2);
        oos.writeObject(m3);
        System.out.println("객체를 파일로 저장했습니다.");

        //NotSerializableException : 객체직렬화 할수 없는 클래
        } catch(Exception e){
        e.printStackTrace();
      }

      // 역 직렬화
      // 메모리 <===== 프로그램 <===== 파일
      FileInputStream fis = null;
      ObjectInputStream ois = null;

      try{
        fis = new FileInputStream("d:\\objeck.dat");
        ois = new ObjectInputStream(fis);
        MemberDTO dto1= (MemberDTO)ois.readObject();
        MemberDTO dto2= (MemberDTO)ois.readObject();
        MemberDTO dto3= (MemberDTO)ois.readObject();

        System.out.println(dto1);
        System.out.println(dto2);
        System.out.println(dto3);
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  }
  ~~~

22.Rest(REpresentation State Transfer) 서버스
  - 하나의 URI가 하나의 고유한 리소스를 대표하도록 설계된 개념

  http://localhost/reply/list?bno=1 -> http://localhost/reply/list/1
  http://localhost/reply/list?bno=7 -> http://localhost/reply/list/7
  하나의 게시물이 하나의 리소스를 갖음

  ~~~JAVA
  // 글번호가 PathVariable로 url에 포함되어 전달됨
  @RequestMapping("veiw/{idx}")
  public ModelAndView view(@PathVariable int idx, ModelAndView mav){
    mav.setViewName("memo/view");
    mav.addObject("dto",memoService.memo_view(idx));
    return mav;
  }
  ~~~
23. 속성변수, 지역변수, 매개변수
  속성변수(property, member variable) : 해당 클래스 안에서만 쓰이는 변수
  지역변수 (local variable) : 특정 지역(method)에서만 사용되는 변수, method가 끝나는 지점에서 자동적으로 소멸
  매개변수 : 클래스나 method 사이를 이동하면서 값을 넘겨주는 변수
  전역 변수 : 프로그램에서 전반적으로 다 사용이 가능
  정적 변수 : 한번 정의 하면 그 값은 계속적으로 메모리에 상주
            프로그램이 종료될 때, 메모리에서 삭제

24. ERP(Enterprise Resource Planning)
  - 전사적 자원 관리 시스템
  - 기업의 모든 자원을 전체적으로 관리하여 최적화된 기업 활동을 통합,관리 시스템에 근거하여 스피드 경영과 투명 경영의 효과를 보는것
  - 회계, 재무, 인사 등 모든 기업 활동을 지원하는 관리 시스템

25. Struts2
  - MVC패턴을 지원하고 웹 애플리케이션을 개발하기 위한 프레임워크
  - POJO 기반 액션 사용, 설정 없이 지향, 다양한 표현식 언어 사용 가능(JSTL)

26. String, StringBuffer, StringBuilder
  ###### String
  - 상수문자열, 한번 생성후 변하지 않는 상수문자열 , 원본이 바뀌지 않음

  ###### StringBuffer
  - 프로그램 내에서 계속 변하는 문자열 용도

  ###### StringBuilder
  - java5에 추가됨, buffer와 기능이 같다
  - StringBuffer은 동기화되지만, StringBuilder는 동기화 x
  - StringBuilder은 다중 스레드에서는 안전하지 않으므로 동기화 필요함, 좀더 가벼움

  ~~~java
  public class StringExam {

  public static void main(String[] args) {
		String str1="java"; //str1== 100번지
		String str2="java"; // str2 ==> 100번지
		String str3=new String("java");
		String str4=new String("java");

		System.out.println(str1==str2);// 주소값 비교
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4)); // 내용 비교

		String str ="hello"+"java"+"jsp";
		System.out.println(str);
		System.out.println(str.replace("hello", "HELLO"));
		System.out.println(str); // 원본 수정 아님

		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		sb.append("jsp");
		sb.append("java");
		System.out.println(sb);
		sb.replace(0, 5, "Hello");
		System.out.println(sb);
	}

}
  ~~~

27. Servlet, Applet
  ##### Servlet - 서버에서 실행되는 자바 프로그램, 플랫폼의 구애를 받지 않음
  ##### Applet - 웹브라우저에서 실행되는 자바 프로그램

28. AJAX의 특징
  - 웹 클라이언트의 화면을 보다 세밀하게 제어하기 위한 기술
  - 필요한 데이터만 보내고 해당 정보만 받음
  - 서버로부터 정보를 받을때 xml, text를 받음
  - 서버와 교환되는 데이터의 양이 적어지므로 트래픽을 낮출 수 있음
  - 클라이언트에서 데이터를 처리하므로 서버에 부담이 덜 가기 떄문에 다른 응답요청에 신속히 응대

29. Inner Class
  - 클래스 안에 선언된 클래스
  - 특정 클래스 내에서만 주로 사용되는 클래스를 내부 클래스로 선언한다.
  - 주로 이벤트 처리

  `장점`
  - 내부 클래스를 사용하면 같은 패키지에 있는 다른 클래스에서도 OUT CLASS를 통하지 않고서는 접근이 불가능-> 보안성 UP
  - 코드의 복잡성을 줄이고 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.

  `단점`
  - 코드의 재사용이 어려움

  ~~~java

  //InnerExam.class
  //InnerExam$Inner.class

  public class InnerExam{ //외부 클래스
    private static int x=10;
    class Inner{ // 내부 클래스
      int getX(){
        return x;
      }
    }

    public static void main(String[] args){
      System.out.println(x);
      InnerExam e = new InnerExam();
      InnerExam.Inner in = e.new Inner();
      System.out.println(in.getX());
    }
  }
  ~~~

30 .API(Application Programming Interface)
  - 응용 프로그램 프로그래밍 인터페이스
  - 응용 프로그램에서 사용할 수 있도록 운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스
  - 다른 서비스에 요청을 보내고 응답을 받기 위해 정의된 명세
  - javaAPI

31. 예외처리
  - 프로그램이 실행되는 동안 특정한 문제가 일어났을 때 처리를 중단하고 다른 처리를 하는 것
  - 예외의 발생으로 실행 중인 프로그램의 갑작스런 비정상 종료를 막고, 정상적인 실행 상태를 유지 할 수 있도록 하는 것
  - 예외 발생 원인
    가. 시스템 장애 : 네트워크 오류, 사용권한 문제
    나. 사용자의 입력 실수 : 존재하지 않는 파일 이름 입력, 받아드릴수 없는 연산
  - 에러 , 경고 , 예외
    가. Error : 컴파일이 안됨
    나. Warning : 실행은 되지만 성능 저하 등의 문제가 발생 가능성
    다. Exception : 컴파일과 실행은 되지만 프로그램이 비정상적으로 종료되는 경우

  - 예외 처리 하는 경우
    가. 선택적인 예외 처리 : 예상되는 코드에 처리 ex> try..catch
    나. 필수적인 예외 처리 : 파일입출력 , 네트워크 관련 작업 , DB 연동 등

    ![alt text](https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/xTa/image/EV_9X_vwDtwXTsoqr6cviQLUTAg.png)

    `예외처리 방법`
    1) try...catch
    2) throws

32. Stream : 데이터의 논리적인 흐름

  ![alt text](http://cfile1.uf.tistory.com/image/1755CE495038B2801DF78B)

  특징
  - 스트림은 FIFO 구조
  - 읽기 , 쓰기가 동시에 되지 않음
  - 읽기, 쓰기가 필요하다면 두개의 스트림을 하나씩 열어야

  입출력 방법
  - byte 단위 입출력(한글은 2byte가 한글자로 구성)
    InputStream , OutputStream
  - 문자 단위 입출력 : InputStreamReader ,OutputStreamWriter
  - buffer를 이용한 입출력 : BufferReader, BufferWriter  

  `버퍼` : 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 임시 메모리 영역

  `버퍼 플러시` : 버퍼에 남아 있는 데이터를 출력시킴 => 버퍼 비우기

  '더블버퍼링' : 이미지 출력 시키는 경우 화면을 지웠다가 다시 그리게 되면 깜빡거리게 됨. 이러한 문제점을 해결하기 위해 화면에 직접 이미지를 그리지 않고 메모리상에 미리 그려놓고 필요할때 한번만 화면에 출력 시키는 방법



33. Unicode와 ASCI
  1. 유니코드
  - 16비트(2바이트) 기반의 다국적 문자 체계
  - 전세계 대부분의 문자를 수용 : 다국어 처리에 효과

  2. ASCI
  - 8비트(1바이트)코드 체계

34. PreparedStatement
    - SQL의 틀을 미리 정해 놓고 , 나중에 값을 지정하는 방식
    - 반복해서 실행되는 동일, 속도가 향상
    - 값 변환 처리
    - 코드의 간결함

    ~~~sql
    pstmt = conn.preparedStatement(
      "insert into Member values(?,?,?)"
    );

    pstmt.setString(1,"kim");
    pstmt.setString(2,"김기사")
    pstmt.setString(3,"hdjakdhka")
    pstmt.executeUpdate();
    ~~~

    SQL ----> parser (해석기)
        ----> optimizer (실행계획 수립)

35. statement
  - 정적 쿼리 시 사용, 매번 파싱과정을 거쳐서 부하가 생길 수 있다.
  - sql문 전체를 명확히 알 수 가 있어서 디버깅이 쉬움

36. Java Bean
  - 자바로 작성된 컴포넌트를 의미
  - 컴포넌트를 사용하면 필요할 때 마다 가져다 사용 할 수 있다.
  - dto(data transfer object), dao(data access object)

37. Connection Pool
  - 데이터베이스와 연결된 커넥션을 미리 만들어서 풀 속에 저장해 두고 있다가 필요할 때에 커넥션을 풀에서 가져다 쓰고 다시 풀에 반환하는 기법
  - 커넥션을 생성하는데 연결 시간이 소비 되지 않는다.
  - 재사용하기 때문에 생성되는 커넥션 수가 많지 않다.

>DATABASE 정리
1. 제약조건(constraint)
- 정의 : 테이블의 해당 컴럼에 원치않는 데이터가 입력/변경/삭제되는 것을 방지하기 위해 테이블 생성시 또는 변경시 설정하는 조건
- 종류 : primary key, foreign key, unique ,check , not null

2. DATABASE에서의 Index(색인)
  - 테이블의 데이터를 보다 빠르게 `검색` 할수 있도록 지원해주는 객체
  - 테이블의 레코드를 빠르게 찾기 위한 자료 구조
  - 구성요소 : rowid , 색인 컬럼값
  - 생성
    ~~~sql
    create index c_emp_name_idx on c_emp(name);
    ~~~
  - 삭제
    ~~~sql
    drop index c_emp_name_idx;
    ~~~
- 삭제   
  - `Primary Key` , `Unique` 제약조건을 만들면 해당 인덱스가 자동으로 생성  
  - 테이블 내의 1개의 컬럼, 혹은 여러 개의 컬럼을 이용하여 생성 될 수 있다.
  - 인덱스를 저장하는 데 필요한 디스크 공간은 보통 테이블을 저장하는데 필요한 디스크 공간보다 작다.


  - DB에서 자료 검색하는 방법
  1) FTS(Full Table Scan) : 테이블을 처음부터 끝까지 검색하는 방법
  2) Index Scan : 인덱스를 사용하여 테이블의 해당 자료를 찾는 방법

  ![alt text](https://d117h1jjiq768j.cloudfront.net/images/default-source/default-album/tutorialimages-album/odbc-album/ruseindxa.gif?sfvrsn=1)

  ![alt text](http://cfile9.uf.tistory.com/image/24385E355413A3D51D7080)

3. 트랜잭션 , 롤백, 커밋
  ###### 트랜잭션  
  - 일련의 작업단위로 특성으로 ACID(원자성, 일관성, 독립성, 지속성)이 있음
  - 분리되어서는 안되는 작업단위로 데이터베이스 내에서 한꺼번에 수행되어야 할 연산들
  - 원자성 : 트랜잭션은 한번에 완료가 되거나 한꺼번에 취소가 되어야 함

  ###### 트랜잭션의 필요성
  - 여러 작업이 한 자원에 동시에 변경, 참조가 필요한 경우, 작업공정이 긴 경우
  - 계좌이체, 원글 삭제 등 한번에 여러 작업이 한 단위로 처리

  ###### 트랜잭션의 시작
  - 첫 DML(데이터조작어)구문이 실행될 때, SELECT에서 제외(insert/ delete/ update)
  - 사용자가 SAVEPOINT를 설정

  ###### 트랜잭션 제어어 : TCL
  - DML문이 실행되어 디비에 저장되거나 (COMMIT) 되돌리기(ROLLBACK) 위해서 실행해야 하는 SQL문
  - COMMIT : 결과를 영구적으로 DB에 반영하는 문
  - ROLLBACK : SQL문의 결과를 이전의 트랜잭션의 끝부분까지 취소하는 SQL문
  - savepoint : 트랜젝션의 한 지점을 표시 (어디까지 복구)

  ###### 트랜잭션 종료
  - COMMIT 수행

  ###### 커밋과 롤백 전
  - ROLLBACK으로 데이터 회복가능
  - 현재 유저는 자싲이 바꾼 데이터를 확인할 수 있음
  - 다른 유저에게는 바뀐 데이터 내용이 반영되지 않음
  - 영향을 받은 레코드는 잠금 상태

  ###### 커밋 후
  - 데이터는 영구적으로 변경
  - 일정 시간이 경과된 후에는 복구 불가능
  - 모든 유저에게 변경 내용이 반영
  - 해당 레코드의 잠금 해제
  - 세이브 포인트 삭제

  ###### 롤백 후  
  - 데이터의 변경이 취소
  - 데이터의 이전 상태가 회복
  - 데이터에 대한 잠금이 해제


  ~~~sql
  inset into dep value('10','영업부','서울');
  savepoint a;
  inset into dep value('20','회계부','서울');
  savepoint b;
  inset into dep value('30','개발부','서울');
  rollback to a;
  select * from dep;
  commit;
  select * from dep;
  ~~~

4. DBMS(DataBase Management System)
  - 응용프로그램이 데이터에 대한 엑세스가 가능하도록 DB를 관리하는 시스템
  - 데이터의 종속성과 중복성의 문제 해결
  - 데이터베이스를 공유할 수 있도록 관리하는 시스템
  - 데이터 중복, 공유, 일관성 유지, 무결성 유지, 보안 보장

  - 데이터의 추가/삭제/조회/변경
  - 데이터의 무결성 유지
  - 트랜잭션 처리
  - 데이터의 백업 및 복원


5. RDBMS(Relative DataBase Management System)
  - 관계형 데이터베이스 관리 시스템 , 일반적으로 관계형 데이터 모델에 기반
  - 데이터를 테이블로 표현하고 테이블을 집합으로 받아들임
  - 데이터를 조작하기 위해서 수학적 연산을 사용

6. DB 정규화의 목적
  - 자료저장의 중복성 배제

  ![alt text](http://cfile30.uf.tistory.com/image/22047F395487A88204085E)  

7. DML, DDL, DCL



> WEB 정리

1. HTML5의 주요 기능
  ###### Canvas 지원
  ###### SVG(Scalable Vector Graphics) 지원
  ###### Geolocation 지원 - 위치정보
  ###### Application Cache 지원
  ###### Web Storage 지원

2. CSS Position 속성
  https://www.zerocho.com/category/CSS/post/5864f3b59f1dc000182d3ea1
  - static : Position 속성의 기본값으로 문서의 기본 flow에 위치하며 top, left, bottom, right 값을 부여
  - absolute : 문서의 기본 flow를 벗어나서 절대좌표를 기준으로 위치하게 됨
  - relative : 문서의 기본 flow를 기준으로 상대적인 위치를 갖는다.
  - fixed : 브라우저를 기준으로 위치가 고정
  - inherit : 부모 요소의 Position 값을 상 (스크롤에 관계 없이)


3. MiddleWare
  - 응용 소프트웨어가 운영 체제로 부터 제공받는 서비스 이외에 추가적으로 이용할 수 있는 서비스를 제공하는 소프트웨어
  - 미들웨어는 양 쪽을 연결하여 데이터를 주고 받을 수 있도록 중간에서 매개 역할을 하는 소프트웨어
  - 유연하고 확장/축소가 편리함
  - 네트워크를 통해서 연결된 여러 개의 컴퓨터에 있는 많은 프로세스들에게 어떤 서비스를 사용할 수 있도록 연결해 주는 소프트웨어
  - 다른 기종 강 플랫폼을 다시 구축할 필요가 없어야 한다.
  - 데이터베이스 시스템, 통신 프로그램 등

4. OSI 7


> 프로젝트 정리

1. 프로젝트 진행 과정
  요구사항분석 -> 설계(데이터베이스, 클래스, 화면) -> 개발 -> 테스트 -> 이관/교육 - 종료

  정보시스템 개발 프로세스

  ###### 폭포수 모델(Waterfall Model)
  - 요구사항 정의 및 분석, 시스템 설계 , 구현, 테스팅이 라는 일련의 단계를 통해 소프트웨어를 개발하는 모델

  ![alt text](http://cfile30.uf.tistory.com/image/24259E3755A284A22121F2)


2. ERD(Entity Relationship Diagram) : 객체관계도
  - 요구분석사항을 바탕으로 데이터모델을 그림으로 표현
  ![alt text](http://cfile26.uf.tistory.com/image/2223604E52969CCF11A358)

  - 개체-관계 모델링 : 구조화된 데이터에 대한 일련의 표현
  - 개체- 관계 다이어그램 : ERM 프로세스의 산출
