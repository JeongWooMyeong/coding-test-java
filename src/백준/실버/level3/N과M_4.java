package 백준.실버.level3;

import java.util.*;
import java.io.*;


public class N과M_4 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        backtrack(1, 0);

        System.out.print(sb);

    }

    public static void backtrack(int start, int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=n;i++){
            arr[depth] = i;
            backtrack(i, depth + 1);
        }

    }

}
