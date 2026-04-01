package 이것이코딩테스트다2.기출문제.최단경로;

import java.util.*;
import java.io.*;

public class 정확한순위2 {
    static int N, M;
    static int[][] map;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        //거리 초기화
        for(int i=1;i<=N;i++){
            Arrays.fill(map[i], INF);
            for(int j=1;j<=N;j++){
                if(i == j){
                    map[i][j] = 0;
                }
            }
        }
        //간선 정보 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;

        }

        //플로이드 워셜 알고리즘 (모든쌍에 대한 최단 경로)
        for(int k=1;k<=N;k++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++){
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        int result = 0;
        for(int i=1;i<=N;i++){
            boolean found = true;
            for(int j=1;j<=N;j++){
                //같은건 제외
                if(i==j) continue;
                //만약 거리 INF 무한대면 정확한 순위 알 수 없는 것임
                if(map[i][j] == INF && map[j][i] == INF) {
                    found = false;
                    break;
                }
            }
            if(found) result++;
        }

        System.out.print(result);





    }

}
