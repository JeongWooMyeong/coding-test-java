package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 미로탈출6 {

    static Map<Integer, Integer> trapIndex;
    static ArrayList<ArrayList<int[]>> edges;
    static ArrayList<ArrayList<int[]>> reversed;
    static int answer = Integer.MAX_VALUE;
    static int[][] d;
    static int INF = (int) 1e9;

    static class Node implements Comparable<Node>{
        int node, cost, state;

        public Node(int node, int cost, int state){
            this.node = node;
            this.cost = cost;
            this.state = state;
        }

        public int compareTo(Node other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps){
        trapIndex = new HashMap<>();
        edges = new ArrayList<>();
        reversed = new ArrayList<>();
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

        for(int i=0;i<traps.length;i++){
            trapIndex.put(traps[i], i);
        }

        d = new int[n+1][1<<traps.length];

        for(int i=1;i<=n;i++){
            Arrays.fill(d[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));
        d[start][0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.node;
            int cost = cur.cost;
            int state = cur.state;

            boolean curTrap = (trapIndex.containsKey(now) && (state & 1 << trapIndex.get(now)) != 0);

            for(int dir=0;dir<2;dir++){
                List<int[]> nextList = (dir == 0) ? edges.get(now) : reversed.get(now);
                for(int[] next : nextList){
                    int nextNode = next[0];

                    boolean nextTrap = (trapIndex.containsKey(nextNode) && (state & 1 << trapIndex.get(nextNode)) != 0);
                    boolean reverse = curTrap ^ nextTrap;

                    boolean valid = ((dir == 0 && !reverse) || (dir == 1 && reverse));

                    if(!valid) continue;

                    int nextState = state;
                    if(trapIndex.containsKey(nextNode)){
                        int bit = trapIndex.get(nextNode);
                        nextState ^= 1 << bit;
                    }

                    int nextCost = next[1];
                    int nd = cost + nextCost;

                    if(d[nextNode][nextState] > nd){
                        d[nextNode][nextState] = nd;
                        pq.offer(new Node(nextNode,nd,nextState));
                    }


                }
            }


        }

        for(int i=0;i<1<<traps.length;i++){
            answer = Math.min(answer, d[end][i]);
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
