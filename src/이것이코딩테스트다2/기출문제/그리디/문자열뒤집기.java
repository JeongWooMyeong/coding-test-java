package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;

public class 문자열뒤집기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count1 = 0;
        int count0 = 0;
        if((str.charAt(0) - '0') == 1){
            count0 += 1;
        }else{
            count1 += 1;
        }

        for(int i=1;i<str.length()-1;i++){
            int a = str.charAt(i) - '0';
            int b = str.charAt(i+1) - '0';

            if(a != b){
                if(b == 1){
                    count0 += 1;
                }else{
                    count1 += 1;
                }
            }
        }

        System.out.println(Math.min(count0, count1));

    }
}
