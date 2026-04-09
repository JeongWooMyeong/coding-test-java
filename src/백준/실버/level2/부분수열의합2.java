package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 부분수열의합2 {
    static int N,S;
    static int[] arr;
    static int result = 0;
    //static boolean[] selected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        //공집합 제외
        if(S == 0 ) result--;

        System.out.print(result);


    }

    static void dfs(int idx, int sum){
        if(idx == N){
            if(sum == S) result++;
            return;
        }
        //선택
        dfs(idx+1, sum + arr[idx]);
        //선택안함
        dfs(idx+1, sum);

    }


}
