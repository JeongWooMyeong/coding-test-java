package 프로그래머스.level4;

import java.util.*;

public class 미로탈출 {

    static class Node implements Comparable<Node> {
        int to, cost, state;

        Node(int to, int cost, int state) {
            this.to = to;
            this.cost = cost;
            this.state = state;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = 1_000_000_000;

    static ArrayList<ArrayList<int[]>> graph;
    static ArrayList<ArrayList<int[]>> reverse;

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {

        Map<Integer, Integer> trapIndex = new HashMap<>();
        for (int i = 0; i < traps.length; i++) {
            trapIndex.put(traps[i], i);
        }

        // ✅ ArrayList<ArrayList<int[]>>
        graph = new ArrayList<>();
        reverse = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];

            graph.get(u).add(new int[]{v, w});
            reverse.get(v).add(new int[]{u, w});
        }

        int maxState = 1 << traps.length;
        int[][] dist = new int[n + 1][maxState];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start][0] = 0;
        pq.add(new Node(start, 0, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;
            int state = cur.state;

            if (dist[now][state] < cost) continue;

            boolean nowTrap = trapIndex.containsKey(now) &&
                    ((state & (1 << trapIndex.get(now))) != 0);

            for (int dir = 0; dir < 2; dir++) {

                ArrayList<int[]> nextList =
                        (dir == 0) ? graph.get(now) : reverse.get(now);

                for (int[] next : nextList) {

                    int nextNode = next[0];
                    int nextCost = next[1];

                    boolean nextTrap = trapIndex.containsKey(nextNode) &&
                            ((state & (1 << trapIndex.get(nextNode))) != 0);

                    boolean isReverse = nowTrap ^ nextTrap;

                    boolean valid = (dir == 0 && !isReverse)
                            || (dir == 1 && isReverse);

                    if (!valid) continue;

                    int nextState = state;

                    if (trapIndex.containsKey(nextNode)) {
                        int bit = trapIndex.get(nextNode);
                        nextState ^= (1 << bit);
                    }

                    int nd = cost + nextCost;

                    if (dist[nextNode][nextState] > nd) {
                        dist[nextNode][nextState] = nd;
                        pq.add(new Node(nextNode, nd, nextState));
                    }
                }
            }
        }

        int answer = INF;
        for (int i = 0; i < (1 << traps.length); i++) {
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