package 백준.실버.level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M260410_2 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N+1];

        dfs(1, 0);

    }

    static void dfs(int start, int idx){
        if(idx == M){
            for(int i=0;i<M;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<=N;i++){
            arr[idx] = i;
            dfs(i+1, idx+1);
        }
    }

}
