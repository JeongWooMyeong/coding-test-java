package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
dfs
 */

public class 전력망둘로나누기6 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges;

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;
        for(int cut=0;cut<wires.length;cut++){
            edges = new ArrayList<>();
            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }
            visited = new boolean[n+1];

            for(int i=0;i<wires.length;i++){
                if(i == cut) continue;
                int a = wires[i][0];
                int b = wires[i][1];

                edges.get(a).add(b);
                edges.get(b).add(a);
            }

            int count = dfs(1);
            int count2 = n - count;
            answer =Math.min(answer, Math.abs(count-count2));

        }



        return answer;
    }

    static int dfs(int start){
        visited[start] = true;
        int count = 1;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);
            if(!visited[next]){
                count += dfs(next);
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
