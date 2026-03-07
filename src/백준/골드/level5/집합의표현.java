package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 집합의표현 {
    static int n,m;
    static ArrayList<Edge> edges = new ArrayList<>();
    static String result = "";
    static int[] parent;

    static class Edge{
        private int a;
        private int b;
        private int command;

        public Edge(int command, int a, int b){
            this.command = command;
            this.a = a;
            this.b = b;
        }

        public int getA(){
            return this.a;
        }

        public int getB(){
            return this.b;
        }

        public int getCommand(){
            return this.command;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.add(new Edge(command, a, b));

        }

        for(int i=0;i<edges.size();i++){
            int command = edges.get(i).getCommand();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();

            if(command == 0){
                union(a,b);
            }else{
                if(findParent(a) != findParent(b)){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
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

}
