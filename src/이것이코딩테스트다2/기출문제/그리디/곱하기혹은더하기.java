package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;

public class 곱하기혹은더하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int result = 0;
        for(int i=0;i<s.length();i++){
            int a = s.charAt(i) - '0';
            if(a <= 1 || result <= 1){
                result += a;
            }else{
                result *= a;
            }
        }

        System.out.println(result);
    }
}
