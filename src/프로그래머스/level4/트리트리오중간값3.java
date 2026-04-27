package 프로그래머스.level4;

import java.util.*;
import java.io.*;


public class 트리트리오중간값3 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int n1;

    public static int solution(int n, int[][] edges){
        int answer = 0;
        graph= new ArrayList<>();
        n1 = n;

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

        int[] dist1 = bfs(1);
        //구한 거리에서 제일 먼 노드 구하기
        int A = furtherNode(dist1);
        int[] distA = bfs(A);
        //A에서 가장 먼 노드 구하기
        int B = furtherNode(distA);
        int diameter = distA[B];

        int[] distB = bfs(B);

        for(int i=1;i<=n;i++){
            //구할때 자기 자신은 빼야함
            if(i == A || i == B) continue;
            int val = Math.min(Math.max(distA[i], distB[i]), diameter);
            answer = Math.max(answer, val);
        }



        return answer;
    }

    static int[] bfs(int start){
        visited = new boolean[n1+1];
        int[] dist = new int[n1+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

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
        for(int i=2;i<=dist.length-1;i++){
            if(dist[idx] < dist[i]){
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
