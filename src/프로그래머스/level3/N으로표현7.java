package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N으로표현7 {

    static List<Set<Integer>> dp;

    public static int solution(int N, int number){
        dp = new ArrayList<>();
        for(int i=0;i<=8;i++){
            dp.add(new HashSet<>());
        }

        //1. N에 대한 조합 만들기
        int concat = 0;
        for(int i=1;i<=8;i++){
            concat = concat * 10 + N;
            dp.get(i).add(concat);
        }

        //2. i에 대한 조합 찾기
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

        return -1;

    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int number = 12;

        System.out.println(solution(N, number));
    }

}
