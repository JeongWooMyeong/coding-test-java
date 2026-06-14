package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 미로탈출4 {

    static ArrayList<ArrayList<int[]>> edges;
    static ArrayList<ArrayList<int[]>> reversed;
    static int[][] dist;
    static int INF = (int) 1e9;
    static Map<Integer,Integer> trapIndex;

    static class Node implements Comparable<Node>{
        int node;
        int cost;
        int state;

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
        edges = new ArrayList<>();
        reversed = new ArrayList<>();
        trapIndex = new HashMap<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for(int i=0;i<traps.length;i++){
            trapIndex.put(traps[i], i);
        }

        for(int[] r : roads){
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            edges.get(from).add(new int[]{to,cost});
            reversed.get(to).add(new int[]{from,cost});

        }

        dist = new int[n+1][1<<traps.length];
        for(int i=1;i<=n;i++) Arrays.fill(dist[i], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0,0));
        dist[start][0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.node;
            int cost = cur.cost;
            int state = cur.state;

            if(dist[now][state] < cost) continue;
            //현재 trap인지 그리고 켜져 있늦지
            boolean curTrap = (trapIndex.containsKey(now) && (state & 1 << trapIndex.get(now)) != 0);

            for(int dir=0;dir<2;dir++){
                List<int[]> nextList = dir == 0 ? edges.get(now) : reversed.get(now);
                for(int[] next : nextList){
                    int nextNode = next[0];
                    int nextCost = next[1];

                    boolean nextTrap = (trapIndex.containsKey(nextNode) && (state & 1 << trapIndex.get(nextNode)) != 0);
                    boolean reverse = curTrap ^ nextTrap;

                    boolean valid = ((dir == 0 && !reverse) || (dir == 1 && reverse));

                    if(!valid) continue;

                    int nextState = state;

                    if(trapIndex.containsKey(nextNode)){
                        int bit = trapIndex.get(nextNode);
                        nextState ^= 1 << bit;
                    }

                    int nd = cost + nextCost;
                    if(dist[nextNode][nextState] > nd){
                        dist[nextNode][nextState] = nd;
                        pq.offer(new Node(nextNode, nd, nextState));
                    }

                }
            }

        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<1<<traps.length;i++){
            answer = Math.min(answer, dist[end][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int start = 1;
        int end = 3;

        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
        int[] traps = {2};

        System.out.println(solution(n, start, end, roads, traps));
    }

}
