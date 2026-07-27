package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 지형이동14 {

    static ArrayList<ArrayList<Edge>> edges;
    static int[][] group;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static boolean[] visited2;
    static int[] dist;
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

    public static int solution(int[][] land, int height){
        int answer = 0;
        n = land.length;
        m = land[0].length;

        visited = new boolean[n][m];
        group = new int[n][m];

        int groupid = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    bfs(i,j,land,groupid,height);
                    groupid++;
                }
            }
        }

        edges = new ArrayList<>();
        for(int i=0;i<groupid;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<4;d++){
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                    int a = group[i][j];
                    int b = group[ni][nj];

                    if(a == b) continue;

                    int diff = Math.abs(land[i][j] - land[ni][nj]);

                    edges.get(a).add(new Edge(b,diff));
                    edges.get(b).add(new Edge(a,diff));


                }
            }
        }

        visited2 = new boolean[groupid];
        dist = new int[groupid];

        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dists = cur.cost;

            if(dist[now] < dists) continue;
            if(visited2[now]) continue;
            visited2[now] = true;
            answer += dists;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;

                if(dist[next] > cost){
                    dist[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }

        }

        return answer;
    }

    static void bfs(int a, int b, int[][] land, int groupid, int height){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});
        visited[a][b] = true;
        group[a][b] = groupid;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                int diff = Math.abs(land[x][y] - land[nx][ny]);

                if(diff <= height){
                    group[nx][ny] = groupid;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }

            }

        }

    }

    public static void main(String[] args) throws Exception{
        int[][] land = {{1,4,8,10},{5,5,5,5},{10,10,10,10},{10,10,10,20}};
        int height = 3;

        System.out.println(solution(land, height));
    }

}
