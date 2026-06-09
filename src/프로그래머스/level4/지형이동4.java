package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 지형이동4 {

    static ArrayList<Edge> edges;
    static int[][] group;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    //static boolean[][] visited;
    static int[] parent;

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
        edges = new ArrayList<>();
        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(group[i], -1);
        }
        //높이 차에 따른 group 번호 지정
        int groupId = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(group[i][j] != -1) continue;
                bfs(i,j,groupId,land,height);
                groupId++;
            }
        }

        //간선 정보 저장
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int r=0;r<4;r++){
                    int ni = i + dx[r];
                    int nj = j + dy[r];

                    if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                    int a = group[i][j];
                    int b = group[ni][nj];
                    int cost = Math.abs(land[i][j] - land[ni][nj]);

                    if(a != b) edges.add(new Edge(a,b,cost));

                }
            }
        }

        Collections.sort(edges);
        int answer = 0;
        parent = new int[groupId];
        for(int i=0;i<groupId;i++){
            parent[i] = i;
        }

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

    static void bfs(int x, int y, int groupId, int[][] land, int height){
        Queue<int[]> q = new LinkedList<>();
        //visited = new boolean[n][m];
        q.offer(new int[]{x,y});
        //visited[x][y] = true;
        group[x][y] = groupId;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            for(int i=0;i<4;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                //if(visited[nx][ny]) continue;
                if(group[nx][ny] != -1) continue;

                int diff = Math.abs(land[x1][y1] - land[nx][ny]);

                if(diff <= height){
                    group[nx][ny] = groupId;
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
