package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 부분수열의합4 {
    static int N, S;
    static int[] arr;
    static int result = 0;

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

        dfs(0, 0, 0);

        System.out.println(result);
    }

    static void dfs(int idx, int sum, int selectedCount){
        if(idx == N){
            //공집합 처리
            if(selectedCount > 0 ){
                if(sum == S){
                    result++;
                }
            }
            return;
        }

        dfs(idx+1, sum + arr[idx], selectedCount+1);
        dfs(idx+1, sum, selectedCount);


    }

}
