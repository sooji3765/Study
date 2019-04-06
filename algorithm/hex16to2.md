
## 16진수를 2진수로 변환하기 

`D2 문제`

~~~java

package swexper;

import java.util.Scanner;

/*
 * 16진수를 2진수로 변환하기
 */
public class Solution4 {

    static String[] hexa2bin={"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    static char[] hex2bin= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        
        for(int i =1;i<=test;i++) {
            
            String input = scan.nextLine();
            
            int len = input.length();
            String answer = "";
            
            for(int j=0;j<len;j++) {
                char ch = input.charAt(j);
                
                for(int k=0;k<hex2bin.length;k++) {
                    if(ch==hex2bin[k]) answer+=hexa2bin[k];
                }
                
            }
            
            System.out.printf("#%d %s\n",i,answer);
        }
        
        scan.close();

    }

}


~~~


## 소수 십진수 2진수로 변환

~~~java
package swexper;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        
        int testcase = scan.nextInt();
        
        
        for(int i=1;i<=testcase;i++) {
            
            double input = scan.nextDouble();
            
            String answer ="";
            int count=0;
            while(count<13) {
                
                if(input==0) break;
                else {
                    //System.out.println("input===>"+input);
                    count++;
                     double temp = input*2;
                     
                    // System.out.println("temp===>"+temp);
                    if(temp>=1) { 
                        answer+="1";
                        input = temp-1;
                    }else {
                        answer+="0";
                        input=temp;
                    }
                }
                    
            }
            if(count<13) System.out.printf("#%d %s\n",i,answer);
            else System.out.println("overflow");
        }
        scan.close();
    }

}

~~~