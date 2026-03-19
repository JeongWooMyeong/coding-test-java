package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 최소비용구하기2 {
    static final int inf = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static List<Integer> visitedNode = new ArrayList<>();
    static int[] d;
    static int start, end;
    static int[] prev;

    static class Edge implements Comparable<Edge>{
        private int next;
        private int cost;

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
            //1 3  5 출력 나오게 하고 싶을때
            if(this.cost == other.cost){
                return this.next - other.next;
            }
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        d = new int[N+1];
        Arrays.fill(d, inf);

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(now).add(new Edge(next, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        visitedNode = getPath(end);
        System.out.println(d[end]);
        System.out.println(visitedNode.size());
        for(int x : visitedNode){
            System.out.print(x + " ");
        }



    }

    static void dijkstra(int str){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;
        //visitedNode.add(start);
        prev = new int[N+1];
        Arrays.fill(prev, -1);

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getNext();
            int dist = cur.getCost();
            if(d[now] < dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int cost = d[now] + edges.get(now).get(i).getCost();
                int next = edges.get(now).get(i).getNext();
                //1 3 5 출력으로 나오게 하고 싶을때 1 4 5 도 정답
                if(d[next] > cost || d[next] == cost && prev[next] > now){
                    d[next] = cost;
                    prev[next] = now;

                    pq.offer(new Edge(next, cost));
                }
            }


        }

    }

    //경로 추적
    static List<Integer> getPath(int end){
        List<Integer> path = new ArrayList<>();
        for(int at = end;at!=-1;at=prev[at]){
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

}
