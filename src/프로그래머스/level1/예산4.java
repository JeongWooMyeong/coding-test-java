package 프로그래머스.level1;

import java.util.*;
import java.io.*;

/*
그리디적 사고
최대 지원할 수 잇는 부서의 개수
d를 작은거부터 지원하면 최대 많은 부서를 지원 할 수 있음
 */

public class 예산4 {

    public static int solution(int[] d, int budget){
        int answer = 0;

        Arrays.sort(d);

        int sum = budget;
        for(int i=0;i<d.length;i++){
            sum -= d[i];
            if(sum < 0) break;
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
