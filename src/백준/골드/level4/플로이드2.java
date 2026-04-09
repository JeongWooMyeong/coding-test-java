package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 플로이드2 {
    static int n, m;
    static int[][] map;
    static int[] dist;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        //dist = new int[n+
        //초기화 필요!!
        for(int i=1;i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        //Arrays.fill(dist, INF);
        //Arrays.fill(map, INF);

        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //아 여기 중복 되서 가중치 작은게 올 수 있으니 이렇게 처리하면 안됌
            map[a][b] = Math.min(map[a][b], cost);

        }

        //플로이드 워셜
        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    map[a][b] = Math.min(map[a][k] + map[k][b], map[a][b]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a=1;a<=n;a++){
            for(int b=1;b<=n;b++){
                //if(a == b) map[a][b] = 0;
                if(map[a][b] == INF) map[a][b] = 0;
                sb.append(map[a][b]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

}
