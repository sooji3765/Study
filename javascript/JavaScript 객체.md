# JavaScript 객체

> 내장 객체 : ducument , window , screen, browser 등

 - Data : 날짜, 시간 작업
 - Number : 수치형 데이터
 - String : 문자열
 - Math : 수학 연산
 - Array : 배열

> 사용자 정의 객체

- 객체 상수로부터 객체 생성
    
    ~~~html
    var myCar = {

        model : "520d",
        speed : 60,
        color : "red",
        break : function{ this.speed -=10;},
        accel : function{
            this.speed+=10;
        }
    }
    myCar.color ="yellow";
    myCar.break();
    ~~~

