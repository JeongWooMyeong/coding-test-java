package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
dfs로 개수 구하기
 */

public class 전력망둘로나누기3 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges;

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;
        //제외할 간선
        for(int cut=0;cut<wires.length;cut++){
            //초기화 실수
            edges = new ArrayList<>();
            visited = new boolean[n+1];

            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }
            //cut이랑 i랑 같을때 간선 제외 (한개)
            for(int i=0;i<wires.length;i++){
                if(i == cut) continue;
                int from = wires[i][0];
                int to = wires[i][1];

                edges.get(from).add(to);
                edges.get(to).add(from);
            }

            int size1 = dfs(1, visited);
            int size2 = n - size1;

            answer = Math.min(answer, Math.abs(size2-size1));

        }


        return answer;
    }

    static int dfs(int start, boolean[] visited){
        visited[start] = true;
        int size = 1;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);
            if(!visited[next]){
                size += dfs(next, visited);
            }
        }

        return size;

    }

    public static void main(String[] args) throws Exception{
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n, wires));
    }

}
