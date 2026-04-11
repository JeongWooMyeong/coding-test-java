package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 별자리만들기3 {
    static int n;
    static ArrayList<Edge> graph = new ArrayList<>();
    static double[][] stars; //거리 구하기 위함
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        private int a;
        private int b;
        private double cost;

        public Edge(int a, int b, double cost){
            this.a = a;
            this.b = b;
            this.cost =cost;
        }

        public int getA(){
            return this.a;
        }

        public int getB(){
            return this.b;
        }

        public double getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            return Double.compare(this.cost, other.cost);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stars = new double[n][2];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++) {
                double x1 = stars[i][0];
                double y1 = stars[i][1];
                double x2 = stars[j][0];
                double y2 = stars[j][1];
                double cost = Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));

                graph.add(new Edge(i,j,cost));
            }

        }
        //크루스칼 비용에 따른 정렬 필요
        Collections.sort(graph);

        double result = 0;
        for(int i=0;i<graph.size();i++){
            int a = graph.get(i).getA();
            int b = graph.get(i).getB();
            double cost = graph.get(i).getCost();

            if(findParent(a) != findParent(b)){
                union(a,b);
                result += cost;
            }


        }

        System.out.printf("%.2f", result);

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
