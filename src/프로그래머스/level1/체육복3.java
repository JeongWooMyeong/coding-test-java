package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 체육복3 {
    public static int solution(int n, int[] lost, int[] reserve){
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    //여분이 있는 사람이 도난 당한 경우
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }

        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int n = 5;

        System.out.println(solution(n,lost,reserve));
    }

}
