package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 플로이드 {

    static int[][] map;
    static int INF = (int) 1e9;
    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[from][to] = Math.min(map[from][to], cost);
            //map[to][from] = Math.min(map[to][from], cost);

        }

        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    if(map[a][k] != INF && map[k][b] != INF){
                        map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }

}
