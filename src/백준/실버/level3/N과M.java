package 백준.실버.level3;

import java.util.*;

public class N과M {
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n+1];

        backtrack(0);

    }

    static void backtrack(int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtrack(depth+1);
                visited[i] = false; //되돌아가기
            }
        }
    }

}
