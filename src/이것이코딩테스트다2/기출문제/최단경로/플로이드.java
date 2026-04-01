package 이것이코딩테스트다2.기출문제.최단경로;

import java.util.*;
import java.io.*;

/*
플로이드 워셜 알고리즘 이용
 */

public class 플로이드 {
    static int INF = (int) 1e9;
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        //거리 초기화
        for(int i=1;i<=n;i++){
            Arrays.fill(map[i], INF);
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //여기서 개선할게 여러 같은 간선인데 cost가 다른게 들어 올수 있으므로 처리
            map[a][b] = Math.min(map[a][b], cost);
            //map[b][a] = cost;
        }

        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) map[i][j] = 0;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
