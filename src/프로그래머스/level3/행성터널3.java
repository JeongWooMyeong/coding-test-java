package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 행성터널3 {

    static int N;
    static List<Planet> planets;
    static List<Edge> edges;
    static int[] parent;
    static int answer;

    static class Planet{
        int x,y,z;
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
            return Integer.compare(this.cost , other.cost);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        planets = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(x,y,z,i));
        }

        edges = new ArrayList<>();
        parent = new int[N];

        for(int i=0;i<N;i++){
            parent[i] = i;
        }

        Collections.sort(planets, (a,b)-> Integer.compare(a.x, b.x));
        for(int i=0;i<N-1;i++){
            int now = planets.get(i).idx;
            int next = planets.get(i+1).idx;

            int cost = Math.abs(planets.get(i).x - planets.get(i+1).x);

            edges.add(new Edge(now,next,cost));

        }

        Collections.sort(planets, (a,b)-> Integer.compare(a.y, b.y));
        for(int i=0;i<N-1;i++){
            int now = planets.get(i).idx;
            int next = planets.get(i+1).idx;

            int cost = Math.abs(planets.get(i).y - planets.get(i+1).y);

            edges.add(new Edge(now,next,cost));

        }

        Collections.sort(planets, (a,b)-> Integer.compare(a.z, b.z));
        for(int i=0;i<N-1;i++){
            int now = planets.get(i).idx;
            int next = planets.get(i+1).idx;

            int cost = Math.abs(planets.get(i).z - planets.get(i+1).z);

            edges.add(new Edge(now,next,cost));

        }

        Collections.sort(edges);

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).from;
            int b = edges.get(i).to;
            int cost = edges.get(i).cost;

            if(findParent(a) != findParent(b)){
                union(a,b);
                answer += cost;
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
