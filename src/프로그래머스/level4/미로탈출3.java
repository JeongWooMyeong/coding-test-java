package 프로그래머스.level4;

import java.util.*;
import java.io.*;

/*
다익스트라 + 비트마스크
 */

public class 미로탈출3 {

    static ArrayList<ArrayList<int[]>> edges;
    static ArrayList<ArrayList<int[]>> reversed;
    static int INF = (int) 1e9;
    static Map<Integer, Integer> trapIndex;
    static int[][] dist;

    static class Node implements Comparable<Node>{
        int to;
        int cost;
        int status;

        public Node(int to, int cost, int status){
            this.to = to;
            this.cost = cost;
            this.status = status;
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

        for(int[] r : roads){
            int u = r[0];
            int v = r[1];
            int w = r[2];

            edges.get(u).add(new int[]{v,w});
            reversed.get(v).add(new int[]{u,w});
        }

        for(int i=0;i<traps.length;i++){
            trapIndex.put(traps[i], i);
        }

        int maxStatus = 1 << traps.length;
        dist = new int[n+1][maxStatus];
        for(int[] d : dist) Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));
        dist[start][0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;
            int status = cur.status;

            if(dist[now][status] < cost) continue;
            //트랩 확인
            boolean curTrap = (trapIndex.containsKey(now) && (status & 1 << trapIndex.get(now)) != 0);

            for(int dir = 0;dir < 2;dir++){
                ArrayList<int[]> nextList = dir == 0 ? edges.get(now) : reversed.get(now);

                for(int[] next : nextList){
                    int nextNode = next[0];
                    int nextCost = next[1];

                    boolean nextTrap = (trapIndex.containsKey(nextNode) && (status & 1 << trapIndex.get(nextNode)) != 0);

                    boolean reversed = curTrap ^ nextTrap;

                    boolean valid = ((dir == 0 && !reversed) || (dir == 1 && reversed));

                    if(!valid) continue;

                    int nextState = status;

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
        for(int i=0;i<(1<<traps.length);i++){
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
