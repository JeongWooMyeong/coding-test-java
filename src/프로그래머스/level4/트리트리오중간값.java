package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 트리트리오중간값 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;

    public static int solution(int n, int[][] edges){
        N = n;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        //간선 정보 입력
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);

        }
        //임의의 노드에서 가장 먼노드 A 찾기
        int[] dist1 = bfs(1);
        int A = furtherNode(dist1);

        //A에서 가장 먼 노드 B 찾기
        int[] distA = bfs(A);
        int B = furtherNode(distA);
        int diameter = distA[B];    //트리 지름

        //4. B에서 각 노드까지 거리 계산
        int[] distB = bfs(B);

        //5. 모든 노드 C에 대해 중간값 계산
        int answer = 0;
        for(int i=1;i<=N;i++){
            if(i == A || i == B) continue;
            // 핵심: C 기준으로 A-B 양 끝까지 거리 중 큰 값
            int val = Math.min(
                    Math.max(distA[i], distB[i]),
                    diameter
            );

            answer = Math.max(answer, val);
        }

        return answer;
    }

    static int[] bfs(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(dist[next] == -1){
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
