package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N으로표현3 {
    static List<Set<Integer>> dp;

    public static int solution(int N, int number){
        int answer = -1;
        dp = new ArrayList<>();

        //초기화 부터
        for(int i=0;i<=8;i++){
            dp.add(new HashSet<>());
        }

        //일단 N으로 만들 수 있는 경우의 수 집어 넣기
        int concat = 0;
        for(int i=1;i<=8;i++){
            concat = 10*concat + N;
            dp.get(i).add(concat);
        }

        for(int i=1;i<=8;i++){
            if(dp.get(i).contains(number)) return i;

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

            if(dp.get(i).contains(number)) return i;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int number = 12;

        System.out.println(solution(N, number));
    }

}
