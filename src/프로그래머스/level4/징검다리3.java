package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 징검다리3 {

    public static int solution(int distance, int[] rocks, int n ){
        int answer = 0;
        //1. 돌 오름차순 정렬
        Arrays.sort(rocks);
        //2. 최소거리 를 mid를 잡음
        int left = 0;
        int right = distance;

        while(left <= right){
            int mid = (left + right) / 2;
            int removed = 0;    //제거해야할 돌 개수
            int prev = 0;
            for(int i=0;i<rocks.length;i++){
                int diff = rocks[i] - prev;
                if(diff < mid) {
                    removed++;
                }else {
                    prev = rocks[i];
                }
            }
            //마지막 거리계산
            if(distance - prev < mid) removed++;

            //돌지운개수가 n이하이면 최소거리 늘려봐야함
            //최소거리가 너무 작다는 이야기
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
