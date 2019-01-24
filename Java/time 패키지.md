# java.time 패키지

- JDK1.8 버전 부터 TIME 패키지 생성
- LocalDate(날짜) + LocalTime(시간) = LocalDateTime
- 시간대까지 다룰때 : LocalDateTime + 시간대 = ZonedDateTime
- 날짜 - 날짜 : Period
- 시간 - 시간 : Duration

> 객체 생성 방법 now(), of()

~~~java
LocalDate date = LocalDate.now(); // 2019-01-21
LocalTime time = LocalTime.now(); // 19:45:30

LocalDate date = LocalDate.of(2014,3,11); // 2014-03-11
LocalTime time = LocalTime.of(23,34,52); // 23:34:52
~~~

> 필드값 변경 with(),plus(), minus()

~~~java
package format;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx1 {

    public static void main(String[] args) {
        
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        
        LocalDate birthday = LocalDate.of(1994, 7, 11);
        LocalTime birthtime = LocalTime.of(20, 30,20);
        
        System.out.println("today :"+today+" "+now);
        System.out.println("birthday :"+birthday+" "+birthtime);
        
        System.out.println(birthday.withYear(1996));
        System.out.println(birthday.plusDays(5));
        System.out.println(birthday.plus(1,ChronoUnit.DAYS));
        

        // truncatedTo(); 지정단위보다 작은 단위는 0으로 처리
        System.out.println(birthtime.truncatedTo(ChronoUnit.HOURS));
        System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range());
        System.out.println(ChronoField.HOUR_OF_DAY.range());

    }

}
~~~

        결과
        today :2019-01-24 17:21:16.141
        birthday :1994-07-11 20:30:20
        1996-07-11
        1994-07-16
        1994-07-12
        20:00
        1 - 24
        0 - 23




> 날짜와 시간 비교 isAfter(), isBefore, isEqual() , compareTo()

1. compareTo() 

~~~java
    // 같으면 1 0 , date1 이전은 -1, 이후 1
    int result = date1.compareTo(date2) 
~~~

2. equal() : 모든 필드 일치, isEqual() : 날짜만 비교

~~~java
    LocalDate kDate = LocalDate.of(2000,2,2); // korea
    JapanesDate jDate = JapanesDate.of(2000,2,2); //japan

    kDate.equal(jDate) // false;
    kDate.isEqual(jDate); // true;
~~~

