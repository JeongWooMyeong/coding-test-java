package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 연산자끼워넣기2 {
    static int N;
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int plus, minus, multi, divide = 0;
        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());

        dfs(1,num[0],plus,minus,multi,divide);

        System.out.println(max);
        System.out.println(min);




    }

    static void dfs(int idx, int sum, int plus, int minus, int multi, int divide){
        if(idx == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if(plus > 0) dfs(idx + 1, sum + num[idx], plus-1, minus, multi, divide);
        if(minus > 0) dfs(idx + 1, sum - num[idx], plus, minus-1, multi, divide);
        if(multi > 0) dfs(idx +1, sum * num[idx], plus, minus, multi-1, divide);
        if(divide > 0){
            dfs(idx +1, sum / num[idx], plus, minus, multi, divide-1);
        }

    }



}
