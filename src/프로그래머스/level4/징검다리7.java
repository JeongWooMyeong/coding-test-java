package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 징검다리7 {

    public static int solution(int distance, int[] rocks, int n){
        int left = 0;
        int right = distance;

        Arrays.sort(rocks);
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int removed = 0;

            int prev = 0;
            for(int i=0;i<rocks.length;i++){
                if(rocks[i] - prev < mid){
                    removed++;
                }else{
                    prev = rocks[i];
                }
            }

            if(distance - prev < mid) removed++;

            if(removed <= n){
                answer = mid;
                left = mid  + 1;
            }else{
                right = mid - 1;
            }


        }

        return answer;


    }

    public static void main(String[] args) throws Exception{
        int distance = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;

        System.out.println(solution(distance, rocks, n));

    }

}
