# 날짜와 시간 & 형식화

> Calendar 클래스 사용

~~~java
package date;

import java.util.Calendar;

public class CanlendarEx2 {

    public static void main(String[] args) {
    
        final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토","일"};
        
        /* Calendar 클래스는 추상 클래스 
           Calendar.getInstance() 메소드르 통해서 객체생성 
        */    

        Calendar date1 = Calendar.getInstance();
        // today
        Calendar date2 = Calendar.getInstance();

        // month을 설정하기 위해서 0-11 +1 해야 원하는 값 출력      
        date1.set(2017, Calendar.AUGUST,15); // 2017-8-15
        
        System.out.println("date1은 "+toString(date1)+DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고,");
        System.out.println("date2은 "+toString(date2)+DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일이다.");
        
        System.out.println("이 해의 몇쩨 주"+date2.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇쩨 주"+date2.get(Calendar.WEEK_OF_MONTH));
        
        System.out.println("DATA == DAY_OF_MONTH"+date2.get(Calendar.DATE)+" "+date2.get(Calendar.DAY_OF_MONTH));
        
        System.out.println("몇 요일 (1-7, 1:일요일)"+date2.get(Calendar.DAY_OF_WEEK));
        
        System.out.println("============================================");
        System.out.println("현재 시간: "+date2.get(Calendar.HOUR_OF_DAY)+"시"+date2.get(Calendar.MINUTE)+"분 "+date2.get(Calendar.SECOND)+"초");
        
    }

    private static String toString(Calendar date) {
        // TODO Auto-generated method stub
        return date.get(Calendar.YEAR)+"년"+(date.get(Calendar.MONTH)+1)+"월"
                +date.get(Calendar.DATE)+"일";
    }

}

~~~

    결과
    date1은 2017년8월15일화요일이고,
    date2은 2019년1월21일월요일이다.
    이 해의 몇쩨 주4
    이 달의 몇쩨 주4
    DATA == DAY_OF_MONTH21 21
    몇 요일 (1-7, 1:일요일)2
    ============================================
    현재 시간: 16시48분37


> set 메서드를 통한 날짜 시간 변경

~~~java

    date2.set(year, month, date, hourOfDay, minute, second);

~~~

> 시간 차이 구하기

~~~java
package date;

import java.util.Calendar;

public class CalendarEx3 {

    public static void main(String[] args) {

        final int[] TIME_UNIT = {3600,60,1};
        final String[] TIME_UNIT_NAME = {"시","분","초"};
        
        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        
        time1.set(Calendar.HOUR_OF_DAY,10);
        time1.set(Calendar.MINUTE, 20);
        time1.set(Calendar.SECOND, 30);
        
        time2.set(Calendar.HOUR_OF_DAY,20);
        time2.set(Calendar.MINUTE, 30);
        time2.set(Calendar.SECOND, 10);
        
        System.out.println("time1 시간 :"+toString(time1));
        System.out.println("time2 시간 :"+toString(time2));
        
        long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
        
        System.out.println("time1-time2 초 차이는 "+diff+"초");
        
        String temp ="";
        for(int i=0; i<TIME_UNIT.length;i++) {
            temp+=diff/TIME_UNIT[i]+TIME_UNIT_NAME[i];
            diff%=TIME_UNIT[i];
            
        }
        System.out.println("시분초로 변경 후 :"+temp);
        

    }
    private static String toString(Calendar date) {
        // TODO Auto-generated method stub
        return date.get(Calendar.HOUR)+"시"+(date.get(Calendar.MINUTE))+"분"
                +date.get(Calendar.SECOND)+"초";
    }

}

~~~

    < 결과 >
    time1 시간 :10시20분30초
    time2 시간:8시30분10초
    time1-time2 초 차이는 36580초
    시분초로 변경 후 :10시9분40초


> 메서드 

~~~java
package date;

import java.util.Calendar;

public class CalendarEx4 {

    public static void main(String[] args) {
        
        Calendar date = Calendar.getInstance();
        
        date.set(2015, 7, 31);
        System.out.println(toString(date));
        
        System.out.println("1일 후");
        date.add(Calendar.DATE, 1);
        System.out.println(toString(date));
        
        System.out.println("6달 전 ");
        date.add(Calendar.MONTH, -6);
        System.out.println(toString(date));
        
        System.out.println("31일 후 roll");
        date.roll(Calendar.DATE, 31);
        System.out.println(toString(date));
        
        System.out.println("31일 후 add");
        date.add(Calendar.DATE, 31);
        System.out.println(toString(date));
        
        
        System.out.println("예외적으로 월 말일 일때 roll사용시");
        date.set(2015, 0, 31);
        System.out.println(toString(date));
        
        date.roll(Calendar.MONTH, 1);
        System.out.println(toString(date));
        
        
    }
    private static String toString(Calendar date) {
        // TODO Auto-generated method stub
        return date.get(Calendar.YEAR)+"년"+(date.get(Calendar.MONTH)+1)+"월"
                +date.get(Calendar.DATE)+"일";
    }
}

~~~

    < 결과 >
    2015년8월31일
    
    1일 후
    2015년9월1일
    
    6달 전 
    2015년3월1일
    
    31일 후 roll
    2015년3월1일
    
    31일 후 add
    2015년4월1일
    
    예외적으로 월 말일 일때 roll사용시
    2015년1월31일
    2015년2월28일


> 달력 출력

~~~java
package date;

import java.util.Calendar;

public class CalendarEx5 {
    public static void main(String[] args) {
        if(args.length!=2) {
            System.out.println("Usage : java CalendarEx5 2017 11");
            return;
        }
        
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        
        Calendar sDay = Calendar.getInstance(); // start
        Calendar eDay = Calendar.getInstance(); //end day
    
        sDay.set(year, month-1, 1); 
        eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));
        
        sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK)+1);
        
        eDay.add(Calendar.DATE, 7-eDay.get(Calendar.DAY_OF_WEEK));
        
        System.out.println("      "+year+"년"+month+"월");
        
        for(int n=1;sDay.before(eDay)||sDay.equals(eDay);sDay.add(Calendar.DATE, 1)) {
            int day = sDay.get(Calendar.DATE);
            System.out.print((day <10)?" "+day :" "+day);
            if (n++%7==0) {
                System.out.println();
            }
        }
    }
}

~~~

