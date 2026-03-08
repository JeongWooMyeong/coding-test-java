package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 플로이드 {
    public static final int INF = (int) 1e9;
    static int v, e;
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        graph = new int[v+1][v+1];
        for(int i=1;i<=v;i++) {
            Arrays.fill(graph[i], INF); //그래프 무한
            graph[i][i] = 0;    //자기자신은 0
        }

        //간선 입력
        for(int i=0;i<e;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //간선입력시 그래프 최단거리는 min
            graph[a][b] = Math.min(graph[a][b], cost);
        }

        //플로이드 알고리즘
        for(int k=1;k<=v;k++){
            for(int i=1;i<=v;i++){
                for(int j=1;j<=v;j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(graph[i][j] == INF) {
                    sb.append("0").append(" ");
                }else{
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString().trim());

    }

}
