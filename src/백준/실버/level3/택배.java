package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 택배 {
    static int n, m;
    static int[][] map;
    static int[][] firstVisited;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        firstVisited = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;  //자기자신도 0으로 초기화
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[a][b] = cost;
            map[b][a] = cost;
            firstVisited[a][b] = b;
            firstVisited[b][a] = a;
        }

        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    //최단 거리 갱신 될때만 갱신
                    if(map[a][b] > map[a][k] + map[k][b]) {
                        map[a][b] = map[a][k] + map[k][b];
                        firstVisited[a][b] = firstVisited[a][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i == j) sb.append("-").append(" ");
                else sb.append(firstVisited[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

}
