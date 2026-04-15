package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 상근이의여행 {
    static int T,N,M;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;
    static int result;
    static StringBuilder sb = new StringBuilder();

    static class Edge{
        int a;
        int b;
        public Edge(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            result= 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];

            for(int i=0;i<=N;i++){
                parent[i] = i;
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edges.add(new Edge(a, b));
            }

            for(int i=0;i<edges.size();i++){
                int a = edges.get(i).a;
                int b = edges.get(i).b;

                if(findParent(a) != findParent(b)){
                    result += 1;
                    union(a,b);
                }

            }


            sb.append(result).append("\n");

        }

        System.out.println(sb.toString());
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
