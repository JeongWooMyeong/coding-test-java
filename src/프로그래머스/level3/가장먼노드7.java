package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs이용한 최단거리
 */

public class 가장먼노드7 {
    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> edges;
    static int n1;

    public static int solution(int n, int[][] edge){
        int answer = 0;
        edges = new ArrayList<>();
        n1 = n;

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        bfs(1);

        int max = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            max = Math.max(dist[i], max);
        }

        for(int i=1;i<=n;i++){
            if(max == dist[i]) answer++;
        }

        return answer;
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n1+1];
        dist = new int[n1+1];
        q.offer(start);
        dist[start] = 0;
        visited[start] = true;

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
        int n = 6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(n, edge));
    }

}
