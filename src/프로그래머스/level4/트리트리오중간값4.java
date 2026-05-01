package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 트리트리오중간값4 {
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int n1;

    public static int solution(int n, int[][] edges){
        int answer = Integer.MIN_VALUE;
        n1 = n;
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        //간선 정보 입력
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //아무접이나 잡고 거리 측정
        int[] dist1 = bfs(1);
        int A = furtherNode(dist1); //가장 먼 노드

        int[] distA = bfs(A);
        int B = furtherNode(distA); //A에서 가장 먼노드
        int diameter = distA[B];
        int[] distB = bfs(B);

        for(int i=1;i<=n;i++){
            //자기 자신거리 넘기기
            if(A == i || B == i) continue;
            int value = Math.min(Math.max(distA[i], distB[i]), diameter);

            answer = Math.max(answer, value);
        }

        return answer;

    }

    static int[] bfs(int start){
        visited = new boolean[n1+1];
        dist = new int[n1+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            //if(visited[now]) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                }
            }
        }

        return dist;
    }

    static int furtherNode(int[] dist){
        int idx = 0;
        for(int i=1;i<dist.length;i++){
            if(dist[i] > dist[idx]){
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        int[][] edges = {{1,2},{2,3},{3,4}};
        System.out.println(solution(n, edges));
    }

}
