package 백준.골드.level2;

import java.util.*;
import java.io.*;

/*
모든쌍의 최단거리 뿐만 아니라
모든 경로 추적해야함 (역추적 필요)
 */

public class 플로이드 {
    static int n, m;
    static int[][] dist;
    static int[][] next;    //경로 저장을 위한 배열

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //도시의 개수
        m = Integer.parseInt(br.readLine());    //버스의 개수

        dist = new int[n+1][n+1];
        next = new int[n+1][n+1];

        //dist 초기화
        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; //자기자신은 0으로 초기화
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(cost, dist[a][b]);
            next[a][b] = b; //a가아닌 a다음에 가야할 노드 (일단 모르니 b로 초기화)

        }

        //플로이드 워셜
        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    if(dist[a][b] > dist[a][k] + dist[k][b]){
                        dist[a][b] = dist[a][k] + dist[k][b];
                        next[a][b] = next[a][k];
                    }
                    //dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                    //next[a][b] = next[a][k];    //a->B a->k를 지나야함
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a=1;a<=n;a++){
            for(int b=1;b<=n;b++){
                if(dist[a][b] == INF || a==b) sb.append("0 ");
                else sb.append(dist[a][b]).append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb);

        StringBuilder pathSb = new StringBuilder();
        for(int a=1;a<=n;a++){
            for(int b=1;b<=n;b++){
                if(dist[a][b] == INF || a==b){
                    pathSb.append("0\n");
                }else{
                    List<Integer> path = getPath(a, b);
                    pathSb.append(path.size()).append(" ");
                    for(int v : path) pathSb.append(v).append(" ");
                    pathSb.append("\n");
                }
            }
        }
        System.out.print(pathSb);

    }
    //거쳐서 간다는 느낌이구나.
    static List<Integer> getPath(int a, int b){
        List<Integer> path = new ArrayList<>();
        if(next[a][b] == 0) return path;
        path.add(a);
        while(a != b){
            a = next[a][b];
            path.add(a);
        }

        return path;
    }

}
