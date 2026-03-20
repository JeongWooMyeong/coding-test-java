package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 작업 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] indegree;
    static int[] arrtime;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        Arrays.fill(indegree, 0);
        arrtime = new int[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arrtime[i] =  Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                int b = Integer.parseInt(st.nextToken());
                graph.get(b).add(i);
                indegree[i] += 1;
            }

        }

        topology_sort();
    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            dp[i] = arrtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next= graph.get(now).get(i);
                dp[next] = Math.max(dp[next], dp[now] + arrtime[next]);
                indegree[next] -= 1;

                if(indegree[next] == 0){
                    q.offer(next);
                }

            }
        }

        //System.out.println(dp[N]);
        int result = 0;
        for(int i=1;i<=N;i++){
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }

}
