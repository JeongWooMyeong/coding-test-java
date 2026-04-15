package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 게임개발3 {
    static int N;
    static int[] arrtime;
    static int[] indegree;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arrtime = new int[N+1];
        indegree = new int[N+1];
        dp = new int[N+1];

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }
        //여기 범위 1~N까지로 해야함
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arrtime[i] = Integer.parseInt(st.nextToken());
            while(true){
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1) break;
                edges.get(pre).add(i);
                indegree[i]++;
            }
        }


        topology_sort();

        StringBuilder sb = new StringBuilder();

        for(int x : dp){
            sb.append(x).append("\n");
        }

        System.out.print(sb.toString());

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            dp[i] = arrtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }


        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                //건물 시간 끝나고 해야하니까 max로 해야하네
                dp[next] = Math.max(dp[next], dp[now] + arrtime[next]);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }

            }
        }

    }

}
