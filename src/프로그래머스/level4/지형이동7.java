package 프로그래머스.level4;

import java.util.*;
import java.io.*;

/*
프림
 */

public class 지형이동7 {

    static int[][] group;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[][] visited;
    static boolean[] pvisited;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
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
            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] land, int height){
        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(group[i], -1);
        }

        visited = new boolean[n][m];
        int groupidx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    bfs(i,j,land,height,groupidx);
                    groupidx++;
                }
            }
        }

        edges = new ArrayList<>();
        for(int i=0;i<groupidx;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<4;d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                    int a = group[i][j];
                    int b = group[ni][nj];
                    int cost = Math.abs(land[i][j] - land[ni][nj]);

                    if(a == b) continue;

                    edges.get(a).add(new Edge(b, cost));
                    edges.get(b).add(new Edge(a, cost));
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[groupidx];
        pvisited = new boolean[groupidx];
        Arrays.fill(d, INF);
        pq.offer(new Edge(0,0));
        d[0] = 0;


        int answer= 0 ;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(pvisited[now]) continue;
            pvisited[now] = true;
            answer += dist;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }

        }

        return answer;

    }

    static void bfs(int sx, int sy, int[][] land, int height, int groupidx){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        visited[sx][sy] = true;
        group[sx][sy] = groupidx;

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
                    visited[nx][ny] = true;
                    group[nx][ny] = groupidx;
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
