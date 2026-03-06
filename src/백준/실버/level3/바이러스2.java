package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 바이러스2 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static int count;

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

        count = 0;
        System.out.print(dfs(1));


    }

    public static int dfs(int x){
        visited[x] = true;
        for(int y : graph.get(x)){
            if(!visited[y]){
                visited[y] = true;
                count++;
                dfs(y);
            }
        }

        return count;
    }

}
