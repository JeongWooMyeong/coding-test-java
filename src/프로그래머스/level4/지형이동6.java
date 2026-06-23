package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 지형이동6 {

    static int[][] group;
    static int[] parent;
    static boolean[][] visited;
    static ArrayList<Edge> edges;
    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost){
            this.from = from;
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

        int groupIdx = 0;
        group = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(group[i], -1);
        }

        visited = new boolean[n][m];
        //height 이하 그룹번호 매기기
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    bfs(i,j,land,height, groupIdx);
                    groupIdx++;
                }
            }
        }

        //크루스칼 알고리즘
        edges = new ArrayList<>();
        parent = new int[groupIdx];
        for(int i=0;i<groupIdx;i++){
            parent[i] = i;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<4;d++){
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                    int a = group[i][j];
                    int b = group[ni][nj];
                    int cost = Math.abs(land[ni][nj] - land[i][j]);

                    if(a != b) {
                        edges.add(new Edge(a, b, cost));
                    }

                }
            }
        }

        Collections.sort(edges);
        int answer = 0;

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).from;
            int b = edges.get(i).to;
            int cost = edges.get(i).cost;

            if(findParent(a) != findParent(b)){
                union(a,b);
                answer += cost;
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

                int diff = Math.abs(land[nx][ny] - land[x][y]);

                if(diff <= height){
                    visited[nx][ny] = true;
                    group[nx][ny] = groupidx;
                    q.offer(new int[]{nx,ny});
                }


            }

        }

    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws Exception{
        int[][] land = {{1,4,8,10},{5,5,5,5},{10,10,10,10},{10,10,10,20}};
        int height = 3;

        System.out.println(solution(land, height));
    }

}
