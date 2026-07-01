package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 부대복귀5 {

    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] answer = new int[sources.length];
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

        for(int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]];
        }

        return answer;
    }

    static void bfs(int start, int n){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, -1);
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
        int n = 5;
        int[][] roads = {{1,2},{1,4},{2,4},{2,5},{4,5}};
        int[] sources = {1,3,5};
        int destination = 5;

        System.out.println(Arrays.toString(solution(n,roads,sources,destination)));
    }

}
