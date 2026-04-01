package 이것이코딩테스트다2.기출문제.그래프이론;

import java.util.*;
import java.io.*;

public class 어두운길 {
    static int N,M;
    static ArrayList<House> edges = new ArrayList<>();
    static int[] parent;

    static class House implements Comparable<House>{
        private int a;
        private int b;
        private int cost;

        public House(int a, int b, int cost){
            this.a =a;
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

        public int compareTo(House other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //집의 수
        M = Integer.parseInt(st.nextToken());   //간선의 수

        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }

        int total = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            total += cost;
            edges.add(new House(a, b, cost));

        }

        Collections.sort(edges);

        int MST = 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                MST += cost;
                union(a,b);
            }

        }

        int result = total - MST;

        System.out.print(result);



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

}
