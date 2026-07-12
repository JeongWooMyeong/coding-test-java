package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 트리의지름 {

    static int n;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[] visited;
    static int maxNode;
    static int maxDist;

    static class Edge{
        int num, cost;
        public Edge(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }


        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));

        }


        maxDist = 0;
        visited = new boolean[n+1];
        dfs(1,0);

        maxDist = 0;
        visited = new boolean[n+1];
        dfs(maxNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist){
        visited[node] = true;
        if(maxDist < dist){
            maxNode = node;
            maxDist = dist;
        }

        for(int i=0;i<edges.get(node).size();i++){
            Edge nextNode = edges.get(node).get(i);
            if(!visited[nextNode.num]){
                dfs(nextNode.num, dist + nextNode.cost);
            }
        }

    }

}
