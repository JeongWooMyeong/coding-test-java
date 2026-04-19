package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
모든 섬 연결하는 최소비용 - MST
크루스칼 알고리즘
 */

public class 섬연결하기 {
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge>{
        int a,b,cost;
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }


    public static int solution(int n, int[][] costs){
        int answer = 0;
        parent = new int[n];
        //부모 노드 초기화
        for(int i=0;i<n;i++){
            parent[i] = i;
        }


        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int pay = cost[2];

            edges.add(new Edge(a,b,pay));
        }

        Collections.sort(edges);

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).a;
            int b = edges.get(i).b;
            int cost = edges.get(i).cost;

            if(findParent(a) != findParent(b)){
                union(a,b);
                answer += cost;
            }

        }

        return answer;
    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;

    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n, costs));
    }

}
