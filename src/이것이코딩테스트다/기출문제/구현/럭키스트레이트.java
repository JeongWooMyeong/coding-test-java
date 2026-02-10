package 이것이코딩테스트다.기출문제.구현;

import java.util.*;

public class 럭키스트레이트 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int cnt = str.length() / 2;
        int result1 = 0;
        int result2 = 0;

        for(int i=0;i<cnt;i++){
            int a = str.charAt(i) - '0';
            result1 += a;
        }

        for(int i=cnt;i<str.length();i++){
            int b = str.charAt(i) - '0';
            result2 += b;
        }

        if(result1 == result2){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }

    }

}
