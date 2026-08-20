package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외판원순회2 {

    static int N;
    static int[][] W;
    static int[][] dp;
    static int answer;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1<<N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,1));

    }

    static int dfs(int cur, int visited){
        //모든 도시 방문
        if(visited == (1 << N) - 1){
            if(W[cur][0] == 0){
                return INF;
            }

            return W[cur][0];
        }
        //이미 계산했으면 반환
        if(dp[cur][visited] != -1) {
            return dp[cur][visited];
        }
        //현재 상태의 최소값
        answer = INF;

        for(int next=0;next<N;next++){
            //아직 방문하지 않은 도시 탐색
            if((visited & (1<<next)) != 0) continue;

            if(W[cur][next] == 0) continue;
            //방문 상태 갱신
            int newVisited = visited | (1<<next);
            //현재 이동 비용 + 다음 상태의 최소비용
            answer = Math.min(answer, W[cur][next] + dfs(next, newVisited));

        }

        return dp[cur][visited] = answer;
    }

}
