package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 징검다리 {
    public static int solution(int distance, int[] rocks, int n){
        int answer = 0;

        //이진탐색은 정렬 필요
        Arrays.sort(rocks);
        int start = 0;
        int end = distance;
        //mid를 최소거리로 잡고 더 작으면 제거
        while(start <= end){
            int mid = (start + end) / 2;
            int removed = 0;
            int prev = 0;

            for(int rock : rocks){
                if(rock - prev < mid){
                    removed++;
                }else{
                    prev = rock;
                }
            }

            //마지막도 계산해야함 (이건 생각 못함)
            if(distance - prev < mid) removed++;

            if(removed <= n){
                answer = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
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
