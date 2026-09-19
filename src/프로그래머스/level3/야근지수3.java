package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 야근지수3 {

    public static long solution(int n, int[] works){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int x : works){
            pq.offer(x);
        }


        while(n > 0){
            int x = pq.poll();

            if(x-1 < 0){
                x = 0;
            }else{
                x -= 1;
            }

            n--;
            pq.offer(x);

        }

        long answer = 0;

        for(int x : pq){
            answer += (long)x * x;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] works = {4,3,3};
        int n = 4;
        System.out.println(solution(n, works));
    }

}
