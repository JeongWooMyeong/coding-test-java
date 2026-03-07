package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 최소스패닝트리2 {
    static int v, e;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;
    static int result = 0;

    static class Edge implements Comparable<Edge>{
        private int x;
        private int y;
        private int cost;

        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        parent = new int[v+1];
        //부모배열 초기화
        for(int i=0;i<v;i++){
            parent[i] = i;
        }
        //간선 정보 입력
        for(int i=0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(x, y, cost));
        }
        //크루스칼 알고리즘은 최단거리부터 구해야하므로 거리기준 정렬 필요
        Collections.sort(edges);
        //간선확인하며 부모 노드가 다르면 사이클이 발생하지 않으므로 union및 cost 갱신
        for(int i=0;i<edges.size();i++){
            int cost = edges.get(i).getCost();
            int x = edges.get(i).getX();
            int y = edges.get(i).getY();

            if(findParent(x) != findParent(y)){
                union(x, y);
                result += cost;
            }

        }

        System.out.print(result);
    }

    static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

}
