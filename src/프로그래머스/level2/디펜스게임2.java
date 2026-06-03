package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 디펜스게임2 {
    public static int solution(int n, int k, int[] enemy){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;

        for(int i=0;i<enemy.length;i++){
            sum += enemy[i];
            pq.offer(enemy[i]);

            if(sum > n){
                if(k > 0){
                    sum -= pq.poll();
                    k--;
                }else{
                    return i;
                }
            }

        }


        return enemy.length;

    }

    public static void main(String[] args) throws Exception{
        int n = 7;
        int k = 3;
        int[] enemy = {4,2,4,5,3,3,1};
        System.out.println(solution(n,k,enemy));
    }

}
