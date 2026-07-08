package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 미로탈출8 {

    static Map<Integer, Integer> trapIndex;
    static ArrayList<ArrayList<int[]>> edges;
    static ArrayList<ArrayList<int[]>> reversed;
    static int[][] d2;
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int node;
        int state;
        int cost;

        public Edge(int node, int state, int cost){
            this.node = node;
            this.state = state;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps){
        trapIndex = new HashMap<>();
        edges = new ArrayList<>();
        reversed = new ArrayList<>();

        d2 = new int[n+1][1<<traps.length];

        for(int i=1;i<=n;i++){
            Arrays.fill(d2[i], INF);
        }

        for(int i=0;i<traps.length;i++){
            trapIndex.put(traps[i], i);
        }

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for(int[] r : roads){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            edges.get(a).add(new int[]{b,cost});
            reversed.get(b).add(new int[]{a,cost});
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0, 0));
        d2[start][0] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.node;
            int state = cur.state;
            int cost = cur.cost;

            if(d2[now][state] < cost) continue;

            boolean curTrap = (trapIndex.containsKey(now) && (state & 1<<trapIndex.get(now)) != 0);

            for(int d=0;d<2;d++){
                List<int[]> nextList = (d % 2 == 0) ? edges.get(now) : reversed.get(now);

                for(int[] next : nextList){
                    int nextnode = next[0];
                    int nextcost = next[1];

                    boolean nextTrap = (trapIndex.containsKey(nextnode) && (state & 1<<trapIndex.get(nextnode))!=0);
                    boolean reverse = curTrap ^ nextTrap;

                    boolean valid = (d == 0 && !reverse) || (d == 1 && reverse);

                    if(!valid) continue;

                    int nextstate = state;

                    if(trapIndex.containsKey(nextnode)){
                        int bit = trapIndex.get(nextnode);
                        nextstate ^= 1<<bit;
                    }

                    int nd = cost + nextcost;

                    if(d2[nextnode][nextstate] > nd){
                        d2[nextnode][nextstate] = nd;
                        pq.offer(new Edge(nextnode,nextstate,nd));
                    }

                }

            }

        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<1<<traps.length;i++){
            answer = Math.min(answer, d2[end][i]);
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int start = 1;
        int end = 3;
        int[][] roads = {{1,2,2},{3,2,3}};
        int[] traps = {2};

        System.out.println(solution(n,start,end,roads,traps));
    }

}
