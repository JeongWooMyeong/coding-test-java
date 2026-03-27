package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 볼링공고르기3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] weight = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            weight[arr[i]]++;
        }

        int sum = N;
        int result = 0;
        for(int i=1;i<=M;i++){
            sum -= weight[i];
            result += weight[i] * sum;
        }

        System.out.print(result);


    }
}
