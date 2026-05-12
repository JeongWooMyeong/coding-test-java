package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs
 */

public class 가장먼노드5 {
    static ArrayList<ArrayList<Integer>> edges;

    static boolean[] visited;
    static int[] dist;

    public static int solution(int n, int[][] edge){
        visited = new boolean[n+1];
        dist = new int[n+1];
        edges = new ArrayList<>();
        int answer = 0;

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] v : edge){
            int a = v[0];
            int b = v[1];

            edges.get(a).add(b);
            edges.get(b).add(a);

        }

        //1번 노드부터 시작
        bfs(1);

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max = Math.max(dist[i], max);
        }

        for(int i=1;i<=n;i++){
            if(dist[i] == max) answer++;
        }

        return answer;

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        int n  = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(n, vertex));
    }

}
