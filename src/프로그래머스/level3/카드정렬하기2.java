package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드정렬하기2 {

    static int N;
    static long answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }

}
