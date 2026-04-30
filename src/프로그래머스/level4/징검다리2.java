package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 징검다리2 {
    public static int solution(int distance, int[] rocks, int n){
        int answer = 0;
        //오름차순 정렬
        Arrays.sort(rocks);
        int start = 1;
        int end = distance;
        //돌사이의 최소거리를 이진탐색 기준으로 잡음 (mid)
        while(start <= end){
            int prev = 0;   //이전값
            int removed = 0;    //제거 돌 개수
            int mid = (start + end) / 2;
            //돌들 사이 거리 구하기
            for(int rock : rocks){
                //최소거리보다 작으면 제거해야지
                if(rock - prev < mid){
                    removed++;
                }else{
                    prev = rock;
                }
            }
            //마지막 distance까지 거리 구해야함
            if(distance - prev < mid) removed++;

            //n은 돌 제거 제한 개수 이하이면 최소거리 더 늘려봐야지
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
        int[] rocks ={2,14,11,21,17};
        int n = 2;

        System.out.println(solution(distance, rocks, n));
    }

}
