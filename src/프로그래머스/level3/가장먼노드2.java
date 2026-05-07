package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
가중치 1로 동일해서 bfs로도 가능
 */

public class 가장먼노드2 {
    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;
    static int[] dist;

    public static int solution(int n, int[][] edge){
        int answer = 0;
        edges = new ArrayList<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int[] e : edge){
            int a = e[0];
            int b = e[1];

            edges.get(a).add(b);
            edges.get(b).add(a);

        }

        bfs(1);

        int max = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            max = Math.max(max, dist[i]);
        }

        for(int x : dist){
            if(x == max) answer++;
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
                    dist[next] = dist[now] + 1;
                    visited[next] = true;
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
