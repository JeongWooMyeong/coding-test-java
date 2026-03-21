package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 도시분할계획 {
    static int N, M;
    static int maxLen = Integer.MIN_VALUE;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        private int a;
        private int b;
        private int cost;

        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int getA(){
            return this.a;
        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i=0;i<=N;i++){
            parent[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, cost));
        }

        //아 계속 정렬 빼먹네.. 크르수칼 정렬
        Collections.sort(edges);

        int result = 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                union(a,b);
                result += cost;
                maxLen = Math.max(maxLen, cost);
            }

        }


        result -= maxLen;
        System.out.print(result);

    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

}
