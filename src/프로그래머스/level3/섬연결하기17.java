package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
크루스칼 알고리즘 (MST)
간선기준
find-union 활용
최소비용순 정렬
 */

public class 섬연결하기17 {
    static ArrayList<Edge> edges;
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }


    public static int solution(int n, int[][] costs){
        int answer = 0;
        edges = new ArrayList<>();
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int[] c : costs){
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            //관계파악이므로 하나만 해줘도 됌
            edges.add(new Edge(from, to, cost));
        }

        Collections.sort(edges);

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).from;
            int b = edges.get(i).to;
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
