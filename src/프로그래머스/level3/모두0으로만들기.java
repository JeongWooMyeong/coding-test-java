package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기 {
    static long answer;
    static ArrayList<ArrayList<Integer>> edgess;
    static boolean[] visited;
    static int n;
    static int[] values;

    public static long solution(int[] a, int[][] edges){
        answer = 0;
        n = a.length;
        int sum = 0;
        int idx = 0;
        values = new int[n];
        for(int x : a) {
            sum += x;
            values[idx++] = x;
        }
        //한쪽 증가 한쪽 감소이므로 주어진 가중치의 합이 0이 아니면 모두 0으로 만들 수 없음
        if(sum != 0) return -1;

        //간선 넣기
        edgess = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edgess.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a1 = e[0];
            int b1 = e[1];
            edgess.get(a1).add(b1);
            edgess.get(b1).add(a1);
        }
        visited = new boolean[n];
        //0부터 시작
        dfs(0);

        return answer;

    }

    static long dfs(int node){
        visited[node] = true;
        long sum = values[node];

        for(int i=0;i<edgess.get(node).size();i++){
            int next = edgess.get(node).get(i);
            if(!visited[next]){
                long child = dfs(next);
                answer += Math.abs(child);
                sum += child;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        System.out.println(solution(a, edges));
    }

}
