package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 여행가자 {
    static int n,m;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static StringTokenizer st;
    static int[] schedule;

    static class Edge{
        private int a;
        private int b;
        private int cost;

        public Edge(int a , int b, int cost){
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

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i =1;i<=n;i++) parent[i] = i;

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(i, j, cost));
            }
        }

        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(cost == 1 && findParent(a) != findParent(b)){
                union(a,b);
            }

        }

        schedule = new int[m];
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){

            int a = findParent(Integer.parseInt(st.nextToken()));
            schedule[i] = a;

        }

        boolean possible = true;
        int root = schedule[0];
        for(int i=1;i<schedule.length;i++){
            if(schedule[i] != root){
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");


    }

    static int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;

    }
}
