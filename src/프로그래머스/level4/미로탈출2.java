package 프로그래머스.level4;

import java.util.*;

/*
잘못된 코드
 */

public class 미로탈출2 {

    static ArrayList<ArrayList<Edge>> edges;
    static ArrayList<ArrayList<Edge>> reversed;
    static Map<Integer, Integer> trapList;
    static int[][] dist;

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

    }

    static class State implements Comparable<State>{
        int node, mask, dist;

        public State(int node, int mask, int dist){
            this.node = node;
            this.mask = mask;
            this.dist = dist;
        }

        public int compareTo(State other){
            return this.dist - other.dist;
        }

    }



    public static int solution(int n, int start, int end, int[][] roads, int[] traps){
        edges = new ArrayList<>();
        reversed = new ArrayList<>();
        trapList = new HashMap<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for(int[] r : roads){
            int from = r[0];
            int to = r[1];
            int cost= r[2];

            edges.get(from).add(new Edge(to,cost));
            reversed.get(to).add(new Edge(from,cost));
        }

        for(int i=0;i<traps.length;i++){
            trapList.put(traps[i], i);
        }
        int maxStatus = 1 << traps.length;
        dist = new int[n+1][maxStatus];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(start, 0, 0));
        dist[start][0] = 0;

        //정방향, 역방향 확인
        while(!pq.isEmpty()){
            State cur = pq.poll();
            if(cur.node == end) return cur.dist;
            if(dist[cur.node][cur.mask] < cur.dist) continue;

            boolean curTrap = trapList.containsKey(cur.node) && ((cur.mask >> trapList.get(cur.node) & 1) == 1);

            //정방향
            for(Edge e : edges.get(cur.node)){
                boolean nextTrap = trapList.containsKey(e.to) && (e.to >> trapList.get(e.to) & 1) == 1;
                boolean reversed = curTrap ^ nextTrap;
                if(!reversed){
                    int nextMask = cur.mask;
                    if(trapList.containsKey(e.to)) nextMask ^= (1 << trapList.get(e.to));
                    int nd = cur.dist + e.cost;
                    if(nd < dist[e.to][nextMask]){
                        dist[e.to][nextMask] = nd;
                        pq.offer(new State(e.to, nextMask, nd));
                    }
                }
            }

            //역방향
            for(Edge e : reversed.get(cur.node)){
                boolean nextTrap = trapList.containsKey(e.to) && ((cur.mask >> trapList.get(e.to)) & 1) == 1;
                boolean reversed = curTrap ^ nextTrap;
                if(reversed){
                    int nextMask = cur.mask;
                    if(trapList.containsKey(e.to)) nextMask ^= (1 << trapList.get(e.to));
                    int nd = cur.dist + e.cost;
                    if(nd < dist[e.to][nextMask]){
                        dist[e.to][nextMask] = nd;
                        pq.offer(new State(e.to, nextMask, nd));
                    }
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int start = 1;
        int end = 3;

        int[][] roads = {{1,2,2},{3,2,3}};
        int[] traps = {2};

        System.out.println(solution(n, start, end, roads, traps));
    }

}
