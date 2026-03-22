package 백준.골드.level4;

import java.io.*;
import java.util.*;

/*
모든 쌍을 비교
플로이드 워셜
DFS /BFS 로 풀어야함
 */

public class 저울 {
    //무겁다.. 안무겁다..
    static boolean[][] graph;
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true; //a가 b보다 무겁다
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(graph[i][k] && graph[k][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }


        for(int i=1;i<=N;i++){
            int count = 0;
            for(int j=1;j<=N;j++){
                if(i == j) continue;
                if(!graph[i][j] && !graph[j][i]){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
