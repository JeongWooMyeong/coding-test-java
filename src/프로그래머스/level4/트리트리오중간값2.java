package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 트리트리오중간값2 {
    static ArrayList<ArrayList<Integer>> graph;
    static int N;

    public static int solution(int n, int[][] edges){
        N = n;
        graph = new ArrayList<>();

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        //가장 먼값 구하기 위해 (지름) 일단 임의의 점에서 가장 먼 노드 구함 (지름 끝점)
        int[] dist1 = bfs(1);
        int A = furtherNode(dist1);

        //가장 먼 A에서 먼 노드 또 구하기 B -> 이 두 사이의 거리가 지름이 됌
        int[] distA = bfs(A);
        int B = furtherNode(distA);
        int diameter = distA[B];

        //B에서 최대거리
        int[] distB = bfs(B);

        //노드 돌면서 (임의의 세점이므로 하나는 구했으니, 다른 두개중에서 최대값이 중간값임)
        //그리고 중간값이 여러개 나오는데 이중에서 최대값 구하면 됌
        int answer = 0;
        for(int i=1;i<=N;i++){
            //C는 A와 B둘중에 같은 값은 제외해야함 (자기 자신 거리)
            if(i == A || i == B) continue;
            //각 노드에서 중간값 구하기
            int val = Math.min(Math.max(distA[i], distB[i]),diameter);
            answer = Math.max(val, answer);
        }

        return answer;
    }

    static int[] bfs(int start){
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

        return dist;
    }

    static int furtherNode(int[] dist){
        int idx = 1;
        for(int i=2;i<dist.length;i++){
            if(dist[idx] < dist[i]) idx = i;
        }
        return idx;
    }


    public static void main(String[] args) throws Exception{
        int n = 4;
        int[][] edges = {{1,2},{2,3},{3,4}};

        System.out.println(solution(n, edges));

    }



}
