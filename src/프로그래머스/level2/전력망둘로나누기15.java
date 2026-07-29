package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 전력망둘로나누기15 {

    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;

    public static int solution(int n, int[][] wires){

        int answer = Integer.MAX_VALUE;

        for(int ban=0;ban<wires.length;ban++){
            edges = new ArrayList<>();
            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }
            visited = new boolean[n+1];

            for(int i=0;i<wires.length;i++){
                if(i == ban) continue;
                int a = wires[i][0];
                int b = wires[i][1];

                edges.get(a).add(b);
                edges.get(b).add(a);
            }

            int size= dfs(1);
            int othersize = n - size;

            int diff = Math.abs(size-othersize);

            answer = Math.min(answer, diff);

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
        int n = 7;
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        System.out.println(solution(n,wires));
    }


}
