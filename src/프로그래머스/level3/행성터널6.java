package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 행성터널6 {

    static int N;
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
    static boolean[] visited;
    static int answer;
    static List<List<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;
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

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(x,y,z,i));
        }

        edges = new ArrayList<>();
        for(int i=0;i<N;i++) edges.add(new ArrayList<>());
        visited = new boolean[N];
        d = new int[N];
        Arrays.fill(d, INF);

        planets.sort((a,b)->Integer.compare(a.x,b.x));

        for(int i=0;i<planets.size()-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);

            int cost = Math.abs(cur.x-next.x);

            edges.get(cur.num).add(new Edge(next.num,cost));
            edges.get(next.num).add(new Edge(cur.num,cost));

        }

        planets.sort((a,b)->Integer.compare(a.y,b.y));

        for(int i=0;i<planets.size()-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);

            int cost = Math.abs(cur.y-next.y);

            edges.get(cur.num).add(new Edge(next.num,cost));
            edges.get(next.num).add(new Edge(cur.num,cost));

        }

        planets.sort((a,b)->Integer.compare(a.z,b.z));

        for(int i=0;i<planets.size()-1;i++){
            Planet cur = planets.get(i);
            Planet next = planets.get(i+1);

            int cost = Math.abs(cur.z-next.z);

            edges.get(cur.num).add(new Edge(next.num,cost));
            edges.get(next.num).add(new Edge(cur.num,cost));

        }

        answer = 0;

        prim(0);

        System.out.println(answer);


    }

    static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(visited[now]) continue;

            visited[now] = true;
            answer += dist;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;

                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next,cost));
                }
            }

        }

    }

}
