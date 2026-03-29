package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

/*
BFS
 */

public class 특정거리의도시찾기2 {
    static int N,M,K,X;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs(X);

        boolean exists = false;
        for(int i=0;i<dist.length;i++){
            if(dist[i] == K){
                System.out.println(i);
                exists = true;
            }
        }

        if(!exists) System.out.println(-1);

    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                int cost = dist[now] + 1;
                if(dist[next] > cost){
                    dist[next] = cost;
                    q.offer(next);
                }
            }
        }
    }

}
