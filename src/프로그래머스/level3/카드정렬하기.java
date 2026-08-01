package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드정렬하기 {

    static int N;
    static int sum;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sum = 0;

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int temp = a + b;
            sum += temp;
            pq.offer(temp);
        }

        System.out.println(sum);
    }

}
