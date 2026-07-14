package 프로그래머스.level4;

import java.util.*;

/*
프림 알고리즘
 */

public class 지형이동12 {

    static int n,m;
    static int[][] group;
    static boolean[][] visited;
    static boolean[] visited2;
    static int[] d;
    static int INF = (int) 1e9;
    static ArrayList<ArrayList<Edge>> edges;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

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
        int answer = 0;

        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        visited = new boolean[n][m];

        int groupid = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    bfs(i,j,land,height,groupid);
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

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[groupid];
        Arrays.fill(d, INF);
        pq.offer(new Edge(0,0));
        d[0] = 0;
        visited2 = new boolean[groupid];

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(d[now] < dist) continue;

            if(visited2[now]) continue;
            visited2[now] = true;
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

    static void bfs(int a, int b, int[][] land, int height, int groupid){
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
                    visited[nx][ny] = true;
                    group[nx][ny] = groupid;
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
