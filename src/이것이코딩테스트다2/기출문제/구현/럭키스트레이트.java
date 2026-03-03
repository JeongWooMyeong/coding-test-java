package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;

public class 럭키스트레이트 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = String.valueOf(sc.nextInt());
        int num2 = num.length() / 2;

        int a = 0;
        for(int i=0;i<num2;i++){
            a += num.charAt(i) - '0';
        }

        int b = 0;
        for(int i = num2;i<num.length();i++){
            b += num.charAt(i) - '0';
        }

        if(a == b){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }



    }
}
