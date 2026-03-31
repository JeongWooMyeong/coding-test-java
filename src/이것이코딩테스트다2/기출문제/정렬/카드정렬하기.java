package 이것이코딩테스트다2.기출문제.정렬;

import java.util.*;
import java.io.*;

public class 카드정렬하기 {
    static int[] score;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        score = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            score[i] = Integer.parseInt(br.readLine());
            pq.add(score[i]);
        }

        int result = 0;
        while(pq.size() > 1){
            int num1 = pq.poll();
            int num2 = pq.poll();

            int sum = num1 + num2;
            result += sum;

            pq.add(sum);

        }

        System.out.print(result);





    }

}
