package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N으로표현 {
    public static int solution(int N, int number){

            List<Set<Integer>> dp = new ArrayList<>();
            //초기화
            for(int j=0;j<=8;j++){
                dp.add(new HashSet<>());
            }
            //자리수만큼 N 담기
            int num = 0;
            for(int i=1;i<=8;i++){
                num = num * 10 + N;
                dp.get(i).add(num);
            }

        for(int i=1;i<=8;i++){
            //이어 붙인 수에 number가 있으면 바로 반환
            if(dp.get(i).contains(number)) return i;
            //j와 i-j 를 조합해서 dp 채우기
            for(int j=1;j<i;j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if(b!=0) dp.get(i).add(a/b);
                    }
                }
            }
            //조합이 number를 포함하면 i 반환
            if(dp.get(i).contains(number)) return i;

        }
        //8번 시도했는데 못찾으면 -1 반환
        return -1;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }
}
