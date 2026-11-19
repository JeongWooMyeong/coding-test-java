package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드정렬하기3 {

    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            int cost =  a+ b;
            sum += cost;

            pq.offer(cost);

        }

        System.out.println(sum);
    }

}
