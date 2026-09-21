package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 회사문화4 {

    static int n,m;
    static int[] wv;
    static List<List<Integer>> edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        wv = new int[n+1];

        edges = new ArrayList<>();
        for(int i=0;i<=n;i++) edges.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;

            edges.get(parent).add(i);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            wv[w] += v;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            sb.append(wv[i]).append(" ");
        }

        System.out.println(sb);

    }

    static void dfs(int node){

        for(int i=0;i<edges.get(node).size();i++){
            int next = edges.get(node).get(i);
            wv[next] += wv[node];
            dfs(next);
        }

    }

}
