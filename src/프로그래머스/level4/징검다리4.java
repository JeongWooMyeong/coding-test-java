package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 징검다리4 {

    public static int solution(int distance, int[] rocks, int n){
        int answer = 0;
        //1. 돌들 오름차순 정렬
        Arrays.sort(rocks);

        //돌들 이 같은 경우가 있을까? 있으면 최소거리 0됌
        int left = 0;
        int right = distance;   //(도착지점이 최대)

        while(left <= right){
            int removed = 0;    //제거해야할 돌의 개수
            int prev = 0;
            int mid = (left + right) / 2; //돌들 사이의 최소거리

            for(int i=0;i<rocks.length;i++){
                int diff = rocks[i] - prev;
                if(diff < mid) {
                    removed++;
                }else {
                    prev = rocks[i];
                }
            }

            //마지막 돌과 distance와의 거리 측정
            if(distance - prev < mid) removed++;

            if(removed <= n){
                answer = mid;
                left = mid + 1;
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
