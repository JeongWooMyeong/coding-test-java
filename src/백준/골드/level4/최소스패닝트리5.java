package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 최소스패닝트리5 {
    static int V,E;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    //static int result = 0;

    static class Edge implements Comparable<Edge>{
        private int a, b, cost;
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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=0;i<=V;i++){
            parent[i] = i;
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, cost));
        }

        Collections.sort(edges);

        long result= 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                union(a, b);
                result += cost;

            }

        }

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
