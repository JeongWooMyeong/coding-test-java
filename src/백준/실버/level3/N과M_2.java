package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M_2 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n+1];

        backtrack(1, 0);

    }

    public static void backtrack(int start, int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<=n;i++){
            arr[depth] = i;
            backtrack(i+1, depth+1);
        }
    }

}
