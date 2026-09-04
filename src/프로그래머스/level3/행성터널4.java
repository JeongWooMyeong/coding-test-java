package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 행성터널4 {

    static int N;
    static int answer;
    static List<Planet> planets;
    static int[] parent;
    static class Planet{
        int idx, x, y, z;

        public Planet(int idx, int x, int y, int z){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

    static List<Edge> edges;
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

        planets = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        answer = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num = i;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(num,x,y,z));
        }

        planets.sort((a,b)->Integer.compare(a.x,b.x));
        edges = new ArrayList<>();
        parent = new int[N];

        for(int i=0;i<N-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);

            int cost = Math.abs(cur.x - next.x);

            edges.add(new Edge(cur.idx,next.idx,cost));
        }

        planets.sort((a,b)->Integer.compare(a.y,b.y));

        for(int i=0;i<N-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);

            int cost = Math.abs(cur.y - next.y);

            edges.add(new Edge(cur.idx,next.idx,cost));
        }

        planets.sort((a,b)->Integer.compare(a.z,b.z));

        for(int i=0;i<N-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);

            int cost = Math.abs(cur.z - next.z);

            edges.add(new Edge(cur.idx,next.idx,cost));
        }

        Collections.sort(edges);

        for(int i=0;i<N;i++){
            parent[i] = i;
        }

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

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

}
