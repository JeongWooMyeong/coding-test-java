package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT3 {
    static int[] dp;
    static int[] buildtime;
    static int T,N,K, W;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            buildtime = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                buildtime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
                indegree[b] += 1;
            }

            W = Integer.parseInt(br.readLine());

            topology_sort();

            sb.append(dp[W]).append("\n");

        }

        System.out.println(sb.toString());
    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        dp = new int[N+1];
        for(int i=1;i<=N;i++){
            dp[i] = buildtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                dp[next] = Math.max(dp[next], dp[now] + buildtime[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }

        }

    }

}
