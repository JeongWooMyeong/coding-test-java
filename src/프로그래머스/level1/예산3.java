package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 예산3 {

    public static int solution(int[] d, int budget){
        int[] prefix = new int[d.length];
        int n = d.length;
        //아무것도 못사는 경우
        int answer = -1;
        Arrays.sort(d);
        prefix[0] = d[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + d[i];
        }

        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(prefix[mid] <= budget){
                answer = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }


        return answer+1;

    }

    public static void main(String[] args) throws Exception{
        int[] d = {2,2,3,3};
        int budget = 10;

        System.out.println(solution(d, budget));
    }

}
