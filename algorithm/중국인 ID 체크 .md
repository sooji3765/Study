# 중국인 ID 검증

1. 문제

    - 18글자로 구성된 ID가 유효한지 체크
    - 지역 코드 : `{"000001","000010","000100","001000","010000","100000"}` 만 유효
    - 생일 코드 : YYYYMMDD 형식, 19000101-20141231 까지 유효
    - 순서 코드 : 3자리, 짝수는 여, 홀수는 남
    - checkSum : 각 자리의 2^17-i * index[i] 값 더한것


2. 입력 

    - 테스트 케이스 
    - 중국인의 아이디 입력

3. 출력 

    - 케이스 순, 유효성 판단


> SOLUTION


~~~java
package samsung;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class IdChina {

    static String[] localCode = {"000001","000010","000100","001000","010000","100000"};
    static int T ;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        
        for(int i=1;i<=T;i++) {
            
            String input = sc.next();
            
            System.out.printf("#%d %s",i,IsChinaId(input));
        }

    }
    private static String IsChinaId(String input) {
        
        boolean local = localCodeCheck(input.substring(0, 6));
        boolean birth = birthCheck(input.substring(6,14));
        String sex = sexCheck(input.substring(14,17));
        char chechSum = input.charAt(17);
        
        
        if(!local) return "Invalid";
        if(!birth) return "Invalid";
        if(sex.equals("Invalid")) return sex;
        
        int sum=0,cnt=0;
        for(int i=0;i<17;i++) {
            cnt = input.charAt(i)-'0';
            sum+=(int)Math.pow(2, 17-i)*cnt;
        }
        

        
        System.out.println(sum%11);
        System.out.println(chechSum);
        
        return sex;
    }
    private static boolean birthCheck(String substring) {
        
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD");
        try {
            Date births = format.parse(substring);
            Date day1 = format.parse("19000101");
            Date day2 = format.parse("20141231");
            
            if(births.compareTo(day1)==-1||births.compareTo(day2)==1)
                return false;
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        
        return true;
    }
    private static boolean localCodeCheck(String substring) {
        
        for(String s : localCode) {
            if(s.equals(substring))
                return true;
        }
        
        return false;
    }
    private static String sexCheck(String substring) {
        // 성별 확인 
        
        int sex = Integer.parseInt(substring);
        
        if(sex==0) return "Invalid";
        else if(sex%2==0) { // 짝수= 여자
            return "Female";
        }
        return "Male";
    }

}

~~~    