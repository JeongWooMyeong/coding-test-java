package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
dfs로 품 -> 익숙해지기 위해
find-union이든 프로세스 형식은 똑같음
어떻게 쓰느냐가 다른겆
 */

public class 전력망둘로나누기2 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges;

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        for(int cut=0;cut<n-1;cut++){
            edges = new ArrayList<>();
            visited = new boolean[n+1];

            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }
            //간선 하나씩 제거
            for(int i=0;i<wires.length;i++){
                if(i == cut) continue;
                int a = wires[i][0];
                int b = wires[i][1];
                edges.get(a).add(b);
                edges.get(b).add(a);
            }
            //임의의 노드에서 시작 (한쪽 구하기)
            int sizeA = dfs(1);
            //한쪽 구한거 빼면 나머지 한쪽
            int sizeB  = n - sizeA;

            int diff = Math.abs(sizeA - sizeB);
            answer = Math.min(diff, answer);

        }

        return answer;
    }

    static int dfs(int node){
        visited[node] = true;
        int size = 1;

        for(int i=0;i<edges.get(node).size();i++){
            int next = edges.get(node).get(i);
            if(!visited[next]){
                visited[next] = true;
                size += dfs(next);
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
