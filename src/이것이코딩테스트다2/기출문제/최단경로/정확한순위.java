package 이것이코딩테스트다2.기출문제.최단경로;

import java.util.*;
import java.io.*;

public class 정확한순위 {
    static int N, M;
    static int[][] map;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(map[i], INF);
            for(int j=1;j<=N;j++){
                if(i== j){
                    map[i][j] = 0;
                }
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //map[a][b] = 1;
        }

        for(int k=1;k<=N;k++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++){
                    //둘 다 가능
                    //map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                    if(map[a][k] != INF && map[k][b] != INF){
                        map[a][b] = 1;  //경로 존재 표시
                    }
                }
            }
        }

        int count = 0;
        for(int i=1;i<=N;i++){
            boolean known = true;
            for(int j=1;j<=N;j++){
                if(i == j) continue;
                if(map[i][j] == INF && map[j][i] == INF){
                    known = false;
                    break;
                }
            }
            if(known) count++;
        }

        System.out.print(count);

    }

}
