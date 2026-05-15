package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N으로표현6 {

    static List<Set<Integer>> dp;

    public static int solution(int N, int number){
        int answer = 0;
        dp = new ArrayList<>();
        for(int i=0;i<=8;i++){
            dp.add(new HashSet<>());
        }

        int concat = 0;
        for(int i=1;i<=8;i++){
            concat = concat * 10 + N;
            dp.get(i).add(concat);
        }

        for(int i=1;i<=8;i++){
            if(dp.get(i).contains(number)) return i;
            for(int j=1;j<i;j++){
                Set<Integer> temp = new HashSet<>();
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        temp.add(a+b);
                        temp.add(a-b);
                        temp.add(a*b);
                        if(b!=0) temp.add(a/b);
                    }
                }
                dp.get(i).addAll(temp);
            }
            if(dp.get(i).contains(number)) return i;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception{
        int N = 2;
        int number = 11;
        System.out.println(solution(N, number));
    }

}
