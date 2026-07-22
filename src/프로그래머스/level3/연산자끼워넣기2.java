package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연산자끼워넣기2 {

    static int N;
    static int[] arr;
    static int plus, minus, multiply, divide;
    static int minValue;
    static int maxValue;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiply = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());

        dfs(1, arr[0], plus, minus, multiply, divide);

        sb.append(maxValue).append("\n");
        sb.append(minValue).append("\n");

        System.out.println(sb.toString());
    }

    static void dfs(int idx, int ans, int plus, int minus, int multiply, int divide){
        if(idx == arr.length){
            maxValue = Math.max(maxValue, ans);
            minValue = Math.min(minValue, ans);
            return;
        }

        if(plus > 0) dfs(idx+1, ans + arr[idx], plus-1, minus, multiply, divide);
        if(minus > 0) dfs(idx+1, ans - arr[idx], plus, minus-1, multiply, divide);
        if(multiply > 0) dfs(idx+1, ans * arr[idx], plus, minus, multiply-1, divide);
        if(divide > 0) dfs(idx+1, ans / arr[idx], plus, minus, multiply, divide-1);
    }

}
