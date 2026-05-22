package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 예산6 {

    public static int solution(int[] d, int budget){
        Arrays.sort(d);

        int answer = 0;

        for(int i=0;i<d.length;i++){
            budget -= d[i];
            if(budget < 0) break;
            answer++;

        }


        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(solution(d, budget));

    }

}
