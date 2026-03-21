package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 네트워크연결2 {
    static int N, M;    //컴퓨터의 수 N 연결할 수 있는 선의 수 M
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;    //부모노드

    static class Edge implements Comparable<Edge>{
        private int a;
        private int b;
        private int cost;

        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int getA(){
            return this.a;
        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
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
        //간선 정보 및 부모 노드 자기자신 초기화
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //간선 정보 입력 (간선 위주) 다익스트라는 노드 위주
            edges.add(new Edge(a, b, cost));
        }

        //간선 비용순으로 오름차순 정렬
        Collections.sort(edges);

        int result = 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();
            //사이클 발생 여부 확인
            if(findParent(a) != findParent(b)){
                union(a, b);
                result += cost;
            }

        }

        System.out.print(result);

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
