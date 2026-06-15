package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장먼노드12 {

    static boolean[] visited;
    static int[] dist;
    static int n1;
    static ArrayList<ArrayList<Integer>> edges;

    public static int solution(int n, int[][] edge){
        int answer = 0;
        n1 = n;

        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] e : edge){
            int a = e[0];
            int b = e[1];

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        int[] dist1 = bfs(1);

        int maxDist = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            maxDist = Math.max(maxDist, dist1[i]);
        }

        for(int i=1;i<=n;i++){
            if(dist1[i] == maxDist) answer++;
        }


        return answer;
    }

    static int[] bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n1+1];
        dist = new int[n1+1];
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

        return dist;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(n, vertex));
    }

}
