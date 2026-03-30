package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 연산자끼워넣기 {
    static int N;
    static int[] Number;
    static int plus, minus, divide, multiply;
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Number = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            Number[i] = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiply = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());


        dfs(1,Number[0], plus,minus,multiply,divide);

        System.out.println(maxValue);
        System.out.println(minValue);

    }

    static void dfs(int idx,int current, int plus, int minus, int multiply, int divide){
        if(idx == N){
            minValue = Math.min(minValue, current);
            maxValue = Math.max(maxValue, current);
            return;
        }

        if(plus > 0) {
            dfs(idx+1, current+Number[idx], plus-1, minus, multiply, divide);
        }
        if(minus > 0) {
            dfs(idx+1, current-Number[idx],plus, minus-1, multiply, divide);
        }
        if(multiply > 0){
            dfs(idx+1, current*Number[idx],plus, minus, multiply-1, divide);
        }
        if(divide > 0){
            dfs(idx+1, current/Number[idx],plus, minus, multiply, divide-1);
        }
    }


}
