package 백준.골드.level4;

import java.util.*;

/*
크루스칼 알고리즘 같은데...
서로소집합 - find, union 사이클 판별, 사이클 아니라면 최소거리 해주는데
코드로 어떻게 짜야할지 모르겠따...
 */
import java.io.*;
import java.util.*;

public class 최소스패닝트리 {
    static int V, E;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge>{
        int u, v, cost;
        Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1;i<=V;i++) parent[i] = i;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, cost));
        }

        Collections.sort(edges);

        int result = 0;
        for(Edge e : edges){
            if(find(e.u) != find(e.v)){
                union(e.u, e.v);
                result += e.cost;
            }
        }

        System.out.println(result);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a > b) parent[b] = a;
        else parent[a] = b;
    }
}
