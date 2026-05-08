package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 전력망둘로나누기7 {
    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        for(int cut=0;cut<wires.length;cut++){
            edges = new ArrayList<>();
            visited = new boolean[n+1];

            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }

            for(int i=0;i<wires.length;i++){
                if(i == cut) continue;
                int a = wires[i][0];
                int b = wires[i][1];

                edges.get(a).add(b);
                edges.get(b).add(a);

            }

            int countA = bfs(1);
            int countB = n - countA;

            answer = Math.min(answer, Math.abs(countA - countB));


        }


        return answer;
    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int count = 1;
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n, wires));
    }

}
