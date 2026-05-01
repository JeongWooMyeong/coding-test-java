package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 전력망둘로나누기4 {

    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        //하나의 간선 제거해서 둘로 나눠야함
        for(int cut=0;cut<wires.length;cut++){
            edges = new ArrayList<>();
            visited = new boolean[n+1];

            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }

            for(int i=0;i<wires.length;i++){
                if(cut == i) continue;
                int from = wires[i][0];
                int to = wires[i][1];

                edges.get(from).add(to);
                edges.get(to).add(from);
            }

            int size1 = bfs(1);
            int size2 = n - size1;

            answer = Math.min(answer, Math.abs(size1 - size2));

        }


        return answer;
    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int dist = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    dist += 1;
                    //제일 기본적인걸.. q에 안담았네..
                    q.offer(next);
                }
            }

        }

        return dist;
    }

    public static void main(String[] args) throws Exception{
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n, wires));
    }

}
