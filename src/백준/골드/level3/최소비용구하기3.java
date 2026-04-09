package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 최소비용구하기3 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] prev;
    static int[] dist;
    static int INF = (int) 1e9;
    static int start, end;

    static class Edge implements Comparable<Edge>{
        int next;
        int cost;

        public Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }

        public int getNext(){
            return this.next;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            if(this.cost == other.cost){
                return this.next - other.next;
            }
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        prev = new int[n+1];
        dist = new int[n+1];

        Arrays.fill(dist, INF);

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, cost));

        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        List<Integer> visitedNode = getPath(end);
        System.out.println(dist[end]);
        System.out.println(visitedNode.size());
        for(int x : visitedNode) System.out.print(x + " ");

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getNext();
            int d = cur.getCost();
            if(dist[now] < d) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).getNext();
                int cost = dist[now] + edges.get(now).get(i).getCost();
                //145로 나옴 135로 나오게 하려면 조건 추가
                //if(dist[next] > cost){
                if(dist[next] > cost || (dist[next] == cost && prev[next] > now)){
                    dist[next] = cost;
                    prev[next] = now;
                    pq.offer(new Edge(next, cost));
                }

            }
        }

    }

    static List<Integer> getPath(int end){
        List<Integer> path = new ArrayList<>();
        //prev[end] 가 아닌 at으로 해야함 (무한루프)
        for(int at=end;at!=0;at=prev[at]){
            path.add(at);
        }

        //Collections.sort(path);
        Collections.reverse(path);

        return path;

    }

}
