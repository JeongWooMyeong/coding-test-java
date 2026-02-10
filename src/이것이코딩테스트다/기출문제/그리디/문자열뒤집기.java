package 이것이코딩테스트다.기출문제.그리디;

import java.util.*;

public class 문자열뒤집기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count0 = 0; //1일때 카운트
        int count1 = 0; //0일때 카운트

        if(str.charAt(0) == '1'){
            count0 += 1;
        }else{
            count1 += 1;
        }

        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) != str.charAt(i+1)){
                if(str.charAt(i+1) == '1') count0 += 1;
                else count1 += 1;
            }
        }

        System.out.println(Math.min(count0, count1));

    }

}
