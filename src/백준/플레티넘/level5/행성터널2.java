package 백준.플레티넘.level5;

import java.util.*;
import java.io.*;

public class 행성터널2 {
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int N;

    static class Planet{
        private int index, x, y, z;
        public Planet(int index, int x, int y, int z){
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getZ(){
            return this.z;
        }

        public int getIndex(){
            return this.index;
        }

    }

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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        Planet[] planets = new Planet[N];

        for(int i=0;i<N;i++){
            parent[i] = i;
        }

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
        }

        //x 기준 정렬
        Arrays.sort(planets, Comparator.comparingInt(p -> p.x));
        for(int i=0;i<N-1;i++){
            int cost = Math.abs(planets[i].getX() - planets[i+1].getX());
            edges.add(new Edge(planets[i].getIndex(), planets[i+1].getIndex(), cost));
        }

        //y 기준 정렬
        Arrays.sort(planets, Comparator.comparingInt(p -> p.y));
        for(int i=0;i<N-1;i++){
            int cost = Math.abs(planets[i].getY() - planets[i+1].getY());
            edges.add(new Edge(planets[i].getIndex(), planets[i+1].getIndex(), cost));
        }

        //Z 기준 정렬
        Arrays.sort(planets, Comparator.comparingInt(p -> p.z));
        for(int i=0;i<N-1;i++){
            int cost = Math.abs(planets[i].getZ() - planets[i+1].getZ());
            edges.add(new Edge(planets[i].getIndex(), planets[i+1].getIndex(), cost));
        }

        Collections.sort(edges);

        long result = 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                 union(a, b);
                 result += cost;
            }
        }

        System.out.println(result);

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
