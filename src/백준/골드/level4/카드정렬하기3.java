package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 카드정렬하기3 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        long result = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            result += sum;
            pq.offer(sum);

        }

        System.out.print(result);
    }
}
