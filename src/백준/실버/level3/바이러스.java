package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 바이러스 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];


        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }


        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.print(bfs(1));
    }

    public static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            //for(int i=0;i<graph.get(x).size();i++){
            for(int y : graph.get(x)){
                //int y = graph.get(x).get(i);
                if(!visited[y]){
                    visited[y] = true;
                    q.offer(y);
                    count++;
                }
            }
        }

        return count;
    }
}
