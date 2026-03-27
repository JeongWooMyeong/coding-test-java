package 백준.플레티넘.level5;

import java.io.*;
import java.util.*;

public class 행성터널 {
    static class Planet{
        int index, x, y, z;
        Planet(int index, int x, int y, int z){
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Planet[] planets = new Planet[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        List<Edge> edges = new ArrayList<>();

        //x 기준 정렬
        Arrays.sort(planets, Comparator.comparingInt(p -> p.x));
        for(int i=0;i<n-1;i++){
            int cost = Math.abs(planets[i].x - planets[i+1].x);
            edges.add(new Edge(planets[i].index, planets[i+1].index, cost));
        }

        //y기준 정렬
        Arrays.sort(planets, Comparator.comparingInt(p -> p.y));
        for(int i=0;i<n-1;i++){
            int cost = Math.abs(planets[i].y - planets[i+1].y);
            edges.add(new Edge(planets[i].index, planets[i+1].index, cost));
        }

        //z기준 정렬
        Arrays.sort(planets, Comparator.comparingInt(p -> p.z));
        for(int i=0;i<n-1;i++){
            int cost = Math.abs(planets[i].z - planets[i+1].z);
            edges.add(new Edge(planets[i].index, planets[i+1].index, cost));
        }

        //Kruskal MST
        Collections.sort(edges);
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;

        long totalCost = 0;
        for(Edge e : edges){
            if(union(e.from, e.to)){
                totalCost += e.cost;
            }
        }

        System.out.println(totalCost);

    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static boolean union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(a == b) return false;
        if(b > a) parent[b] = a;
        else parent[a] = b;
        return true;
    }

}
