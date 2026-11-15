package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 행성터널5 {

    static int N;
    static int answer;
    static List<Planet> planets;
    static class Planet{
        int x,y,z,num;

        public Planet(int x, int y, int z, int num){
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }

    }
    static List<Edge> edges;
    static class Edge implements Comparable<Edge>{
        int from,to,cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }
    static int[] parent;


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

        planets.sort((a,b)->a.x-b.x);
        for(int i=0;i<planets.size()-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);
            int cost = Math.abs(cur.x - next.x);

            edges.add(new Edge(cur.num, next.num,cost));

        }

        planets.sort((a,b)->a.y-b.y);

        for(int i=0;i<planets.size()-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);
            int cost = Math.abs(cur.y - next.y);

            edges.add(new Edge(cur.num, next.num,cost));

        }

        planets.sort((a,b)->a.z-b.z);

        for(int i=0;i<planets.size()-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);
            int cost = Math.abs(cur.z-next.z);

            edges.add(new Edge(cur.num, next.num,cost));
        }

        Collections.sort(edges);

        answer = 0;

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
