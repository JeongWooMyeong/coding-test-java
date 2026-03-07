package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 네트워크연결 {
    static int v, e;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;

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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());    //노드의 개수
        e = Integer.parseInt(br.readLine());    //간선의 개수

        //부모배열 초기화 (1~
        parent = new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i] = i;
        }

        //간선정보 입력
        for(int i=0;i<e;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, cost));
        }

        //간선 정보 거리순으로 정렬
        Collections.sort(edges);

        //간선 하나씩 확인하며 거리 갱신
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

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

        if(b > a)   parent[b] = a;
        else parent[a] = b;

    }

}
