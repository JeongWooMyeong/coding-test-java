package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 카드정렬하기2 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
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
