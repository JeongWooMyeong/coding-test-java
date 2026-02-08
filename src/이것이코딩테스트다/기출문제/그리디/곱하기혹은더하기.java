package 이것이코딩테스트다.기출문제.그리디;

import java.util.*;

public class 곱하기혹은더하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int input = 0;
        int result = 0;

        for(int i=0;i<s.length();i++){
            input = s.charAt(i) - '0';
            //System.out.println(input);
            //1을 고려해야하네.. 더하기로..
            if(input <= 1 || result <= 1){
                result += input;
            }else{
                result *= input;
            }
        }

        System.out.println(result);

    }
}
