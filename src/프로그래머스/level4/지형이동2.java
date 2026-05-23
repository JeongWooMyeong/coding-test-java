package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 지형이동2 {
    static ArrayList<Edge> edges;
    static int[] parent;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Edge implements Comparable<Edge>{
        int from,to,cost;
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
        int answer = 0;
        //int max = Integer.MIN_VALUE;

        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                int node = x * m + y;
                for(int d=0;d<4;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nextnode = nx * m + ny;

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    int a= node;
                    int b = nextnode;
                    int diff = Math.abs(land[nx][ny] - land[x][y]);
                    int cost = diff > height ? diff : 0;

                    if(a != b) {
                        edges.add(new Edge(a, b, cost));
                    }

                }
            }
        }

        Collections.sort(edges);

        int totalNodes = n * m;
        parent = new int[totalNodes];
        for(int i=0;i<totalNodes;i++){
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
