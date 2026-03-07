package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 별자리만들기 {
    static double[][] stars;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;
    static int n;
    static double result = 0;

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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    //별자리 개수
        stars = new double[n][2];//별자리 index 와 x, y 좌표
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        //별정보 입력
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }
        //별 좌표 및 간선 정보
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double cost = Math.sqrt(Math.pow(stars[i][0]-stars[j][0],2) + Math.pow(stars[i][1]-stars[j][1], 2));
                edges.add(new Edge(i, j, cost));
            }
        }
        //간선 거리 정렬 빼먹음...
        Collections.sort(edges);

        //간선 하나씩 확인하면서
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            Double cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                union(a, b);
                result += cost;
            }

        }

        System.out.printf("%.2f\n", result);
        //System.out.printf("%.3f\n", result);
        //System.out.printf("%d\n", result);

    }

    public static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    public static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

}
