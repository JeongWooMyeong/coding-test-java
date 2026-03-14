package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M_3 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        backtrack(0);

    }

    public static void backtrack(int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            arr[depth] = i;
            backtrack(depth+1);
        }
    }

}
