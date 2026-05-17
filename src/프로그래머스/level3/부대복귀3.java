package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs로 풀기
 */

public class 부대복귀3 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] dist;
    static int INF = (int) 1e9;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){

        visited = new boolean[n+1];
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        dist = new int[n+1];
        Arrays.fill(dist, INF);

        for(int[] r : roads){
            int a = r[0];
            int b = r[1];

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        bfs(destination);

        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]];
            if(answer[i] == INF) answer[i] = -1;
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
        int n = 5;
        int[][] roads = {{1,2},{1,4},{2,4},{2,5},{4,5}};
        int[] sources = {1,3,5};
        int destination = 5;

        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }

}
