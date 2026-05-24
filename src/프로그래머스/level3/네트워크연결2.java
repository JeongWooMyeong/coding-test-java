package 프로그래머스.level3;


import java.util.*;
import java.io.*;

/*
크루스칼
 */

public class 네트워크연결2 {
    static int n,m;
    static ArrayList<Edge> edges;
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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,cost));
        }

        Collections.sort(edges);

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).from;
            int b = edges.get(i).to;
            int cost = edges.get(i).cost;

            if(findParent(a) != findParent(b)){
                union(a,b);
                answer += cost;
            }

        }

        System.out.println(answer);

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

}
