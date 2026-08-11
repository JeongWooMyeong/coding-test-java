package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 행성터널 {

    static int N;
    static ArrayList<Edge> edges;
    static ArrayList<Planet> planets;
    static long answer;
    static int[] parent;
    static class Planet{
        int x;
        int y;
        int z;
        int idx;

        public Planet(int x, int y, int z, int idx){
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }

    }

    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        planets = new ArrayList<>();
        answer = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(x,y,z,i));
        }

        planets.sort((a,b)-> Integer.compare(a.x, b.x));
        for(int i=0;i<N-1;i++){
            Planet a = planets.get(i);
            Planet b = planets.get(i+1);
            int cost = Math.abs(a.x-b.x);

            edges.add(new Edge(a.idx, b.idx, cost));
        }

        planets.sort((a,b)-> Integer.compare(a.y, b.y));
        for(int i=0;i<N-1;i++){
            Planet a = planets.get(i);
            Planet b = planets.get(i+1);
            int cost = Math.abs(a.y-b.y);

            edges.add(new Edge(a.idx, b.idx, cost));
        }


        planets.sort((a,b)-> Integer.compare(a.z, b.z));
        for(int i=0;i<N-1;i++){
            Planet a = planets.get(i);
            Planet b = planets.get(i+1);
            int cost = Math.abs(a.z-b.z);

            edges.add(new Edge(a.idx, b.idx, cost));
        }

        Collections.sort(edges);

        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).from;
            int b = edges.get(i).to;
            int cost = edges.get(i).cost;

            if(findParent(a) != findParent(b)){
                answer += cost;
                union(a,b);
            }

        }

        System.out.println(answer);
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
