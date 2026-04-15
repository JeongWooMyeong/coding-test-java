package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 네트워크연결6 {
    static int N, M;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int a, b, cost;

        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        //부모노드 자기 자신으로 초기화
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }

        //간선 정보 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,cost));
        }

        Collections.sort(edges);

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).a;
            int b = edges.get(i).b;
            int cost = edges.get(i).cost;

            if(findParent(a) != findParent(b)){
                union(a,b);
                result += cost;
            }

        }

        System.out.println(result);


    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;
    }

}
