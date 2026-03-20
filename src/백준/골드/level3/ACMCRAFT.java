package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT {
    static int T, N, K, W;
    static ArrayList<ArrayList<Craft>> graph;
    static int[] indegree;
    static int[] arrtime;
    static int result = 0;

    static class Craft{
        private int next;
        private int time;

        public Craft(int next, int time){
            this.next = next;
            this.time = time;
        }

        public int getNext(){
            return this.next;
        }

        public int getTime(){
            return this.time;
        }

    }

    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //StringTokenizer st;

            T = Integer.parseInt(br.readLine());
            for(int t=0;t<T;t++) {
                graph = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                for (int i = 0; i <= N; i++) {
                    graph.add(new ArrayList<>());
                }

                st = new StringTokenizer(br.readLine());
                arrtime = new int[N + 1];
                for (int i = 1; i <= N; i++) {
                    arrtime[i] = Integer.parseInt(st.nextToken());
                }

                indegree = new int[N + 1];
                Arrays.fill(indegree, 0);

                for (int i = 0; i < K; i++) {
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    graph.get(a).add(new Craft(b, arrtime[b]));
                    indegree[b] += 1;

                }

                W = Integer.parseInt(br.readLine());

                topology_sort();
            }



    }

    static void topology_sort(){
        Queue<Craft> q = new LinkedList<>();
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            dp[i] = arrtime[i];
            if(indegree[i] == 0){
                q.offer(new Craft(i, arrtime[i]));
            }
        }

        while(!q.isEmpty()){
            Craft cur = q.poll();
            int now = cur.getNext();
            int dist = cur.getTime();


            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i).getNext();
                dp[next] = Math.max(dp[next], dp[now] + arrtime[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(new Craft(next, dp[next]));
                }

            }

        }

        System.out.println(dp[W]);

    }

}
