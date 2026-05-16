package 프로그래머스.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
나는 sources를 출발점으로 두고 해서
sources가 많아지면 시간 초과 위험 있음
destination에서 출발점으로 잡으면
한번만 실행하고 sources의 거리를 구할 수 있음
 */

public class 부대복귀2 {
    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;
    static int[] dist;
    static int INF = (int) 1e9;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] answer = new int[sources.length];
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        //간선정보 입력
        for(int[] r : roads){
            int a= r[0];
            int b = r[1];
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        visited = new boolean[n+1];
        bfs(destination);

        //sorce에 따른 최단 경로 구하기
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

        System.out.println(Arrays.toString(solution(n,roads,sources, destination)));
    }

}
