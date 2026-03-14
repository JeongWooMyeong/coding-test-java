package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M_8 {
    static int n, m;
    static int[] arr;
    static int[] arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtrack(0,0);

        System.out.print(sb);
    }

    public static void backtrack(int start, int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                sb.append(arr2[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<n;i++){
            arr2[depth] = arr[i];
            backtrack(i, depth+1);
        }

    }
}
