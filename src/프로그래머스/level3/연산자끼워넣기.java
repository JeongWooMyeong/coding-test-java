package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연산자끼워넣기 {

    static int N;
    static int[] arr;
    static int plus, minus, multiply, divide;
    static int maxValue;
    static int minValue;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiply = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());

        dfs(1, arr[0], plus, minus, multiply, divide);

        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append("\n");
        sb.append(minValue);

        System.out.println(sb.toString());
    }

    static void dfs(int idx, int sum, int plus, int minus, int multiply, int divide){
        if(idx == arr.length){
            maxValue = Math.max(maxValue, sum);
            minValue = Math.min(minValue, sum);
            return;
        }

        if(plus > 0) dfs(idx+1, sum + arr[idx], plus-1, minus, multiply, divide);
        if(minus > 0) dfs(idx+1, sum - arr[idx], plus, minus-1, multiply, divide);
        if(multiply > 0) dfs(idx+1, sum * arr[idx], plus, minus, multiply-1, divide);
        if(arr[idx] != 0 && divide > 0) dfs(idx+1, sum / arr[idx], plus, minus, multiply, divide-1);
    }

}
