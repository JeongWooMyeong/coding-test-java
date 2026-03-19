package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 부분수열의합 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        //공집합 제외
        if(S == 0) count--;

        System.out.print(count);

    }

    static void dfs(int idx, int sum){
        if(idx == N){
            if(sum == S) count++;
            return;
        }
        //현재 원소 선택 부분 수열이라 선택이란느 개념으로 보면 되나..
        dfs(idx+1, sum + arr[idx]);
        //현재 원소 선택하지 않음
        dfs(idx+1, sum);

    }

}
