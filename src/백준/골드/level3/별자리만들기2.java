package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 별자리만들기2 {
    static double[][] stars;
    static int n;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        private int a;
        private int b;
        private double cost;

        public Edge(int a, int b, double cost){
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

        //star x, y 좌표 배열 정의
        stars = new double[n+1][2];
        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }


        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());

        }

        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                double x1 = stars[i][0];
                double y1 = stars[i][1];
                double x2 = stars[j][0];
                double y2 = stars[j][1];

                double cost = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

                edges.add(new Edge(i, j, cost));
                //edges.add(new Edge(j, i, cost));
            }
        }


        Collections.sort(edges);

        double result = 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            double cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                union(a, b);
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

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

}
