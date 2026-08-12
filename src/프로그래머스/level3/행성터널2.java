package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 행성터널2 {

    static int N;
    static ArrayList<ArrayList<Edge>> edges;
    static ArrayList<Planet> planets;
    static int[] d;
    static int INF = Integer.MAX_VALUE;
    static int answer;
    static boolean[] visited;

    static class Planet{
        int x, y, z;
        int idx;

        public Planet(int x, int y, int z, int idx){
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }

    }

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost){
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
        planets = new ArrayList<>();
        edges = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(x,y,z,i));

        }

        for(int i=0;i<N;i++){
            edges.add(new ArrayList<>());
        }

        Collections.sort(planets, (a,b)->Integer.compare(a.x,b.x));
        for(int i=0;i<N-1;i++){
            int a = planets.get(i).idx;
            int b = planets.get(i+1).idx;

            int cost = Math.abs(planets.get(i).x - planets.get(i+1).x);
            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));

        }

        Collections.sort(planets, (a,b)->Integer.compare(a.y,b.y));
        for(int i=0;i<N-1;i++){
            int a = planets.get(i).idx;
            int b = planets.get(i+1).idx;

            int cost = Math.abs(planets.get(i).y - planets.get(i+1).y);
            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));

        }

        Collections.sort(planets, (a,b)->Integer.compare(a.z,b.z));
        for(int i=0;i<N-1;i++){
            int a = planets.get(i).idx;
            int b = planets.get(i+1).idx;

            int cost = Math.abs(planets.get(i).z - planets.get(i+1).z);
            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));

        }

        prim(0);

        System.out.println(answer);

    }

    static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[N];
        Arrays.fill(d, INF);
        pq.offer(new Edge(start, 0));
        d[start] = 0;
        visited = new boolean[N];
        //visited[start] = true;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(d[now] < dist) continue;
            if(visited[now]) continue;

            visited[now] = true;
            answer += dist;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;

                if(!visited[next] && d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next,cost));
                }

            }


        }

    }

}
