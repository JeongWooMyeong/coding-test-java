package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
플로이드 워셜
 */

public class 최단경로4 {
    static int v, e;
    static int start;
    static int[][] dist;
    static int INF = (int)1e9;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        dist = new int[v+1][v+1];

        for(int i=1;i<=v;i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = cost;
        }

        for(int k=1;k<=v;k++){
            for(int a=1;a<=v;a++){
                for(int b=1;b<=v;b++){
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=v;i++){
            if(dist[start][i] == INF){
                sb.append("INF").append("\n");
            }else {
                sb.append(dist[start][i]).append("\n");
            }

        }

        System.out.print(sb);



    }
    
}
