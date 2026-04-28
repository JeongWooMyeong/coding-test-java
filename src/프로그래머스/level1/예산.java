package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 예산 {
    public static int solution(int[] d, int budget){
        Arrays.sort(d);
        int answer = 0;
        int cost = 0;
        for(int pay : d){
            cost += pay;
            if(cost <= budget){
                answer += 1;
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] d= {1,3,2,5,4};
        int budget = 9;

        System.out.println(solution(d, budget));

    }
}
