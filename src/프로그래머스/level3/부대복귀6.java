package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 부대복귀6 {

    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> edges;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] r : roads){
            int a = r[0];
            int b = r[1];

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        bfs(destination, n);

        int[] answer = new int[sources.length];
        int idx = 0;
        for(int x : sources){
            answer[idx] = dist[x];
            idx++;
        }

        return answer;
    }

    static void bfs(int start, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, -1);
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
        int n = 3;
        int[][] roads = {{1,2},{2,3}};
        int[] sources = {2,3};
        int destination = 1;

        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }
}
