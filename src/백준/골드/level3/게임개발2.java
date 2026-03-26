package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 게임개발2 {
    static int N;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] indegree;
    static int[] arrtime;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        indegree = new int[N+1];
        arrtime = new int[N+1];
        Arrays.fill(indegree, 0);

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arrtime[i] = Integer.parseInt(st.nextToken());
            while(true){
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1) break;
                edges.get(pre).add(i);
            }
        }

        topology_sort();


    }

    static void topology_sort(){
        Queue<Integer> q = new ArrayDeque<>();
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            dp[i] = arrtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next= edges.get(now).get(i);
                dp[next] = Math.max(dp[next], dp[now] + arrtime[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(dp[i]).append("\n");
        }
        System.out.print(sb);
    }

}
