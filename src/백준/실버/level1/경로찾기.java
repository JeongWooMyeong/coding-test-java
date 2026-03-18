package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 경로찾기 {
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1;k<=N;k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
//                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][i]);
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }


        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= N; j++) {
               System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }




    }

}
