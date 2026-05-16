package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기2 {
    static long answer;
    static ArrayList<ArrayList<Integer>> edges2;
    static boolean[] visited;
    static int[] values;
    static int n;

    public static long solution(int[] a, int[][] edges){
        answer = 0;
        n = a.length;

        //누적합 a 구하기
        //만약 누적합이 0이 아니라면, -1 return
        int sum = 0;
        values = new int[n];
        for(int i=0;i<n;i++){
            sum += a[i];
            values[i] = a[i];
        }
        //모두 0이 아니라면 만들 수 없음
        if(sum != 0 ) return -1;
        //ex) 2, -1 -> -1 넘기면 루트에 1남으므로 0만들 수 없음
        //간선 정보 입력
        edges2 = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges2.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int a1 = e[0];
            int b1 = e[1];

            edges2.get(a1).add(b1);
            edges2.get(b1).add(a1);
        }

        visited = new boolean[n];
        //0번 노드부터 시작 (루트로 잡고)
        long sums = dfs(0);
        System.out.println(sums);


        return answer;
    }

    static long dfs(int node){
        visited[node] = true;
        long sum = values[node];

        for(int i=0;i<edges2.get(node).size();i++){
            int next = edges2.get(node).get(i);
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
