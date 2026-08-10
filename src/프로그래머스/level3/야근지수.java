package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 야근지수 {

    static PriorityQueue<Integer> pq;
    static long answer;

    public static long solution(int n, int[] works){
        pq = new PriorityQueue<>(Collections.reverseOrder());
        answer = 0;

        for(int x : works){
            pq.add(x);
        }

        for(int i=0;i<n;i++){
            int x = pq.poll();
            if(x - 1 < 0){
                x = 0;
            }else{
                x -= 1;
            }
            pq.add(x);
        }

        for(int x : pq){
            answer += (long)Math.pow(x, 2);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] works = {4,3,3};
        int n = 4;

        System.out.println(solution(n, works));
    }

}
