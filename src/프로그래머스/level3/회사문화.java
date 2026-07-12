package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 회사문화 {

    static ArrayList<ArrayList<Integer>> edges;
    static int[] wv;
    static StringBuilder sb = new StringBuilder();
    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int b = Integer.parseInt(st.nextToken());
            if(b != -1){
                edges.get(b).add(i);
            }
        }

        wv = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            wv[a] = v;
        }

        dfs(1);

        for(int i=1;i<=n;i++){
            sb.append(wv[i]).append(" ");
        }

        System.out.println(sb.toString());

    }

    static void dfs(int node){
        for(int next : edges.get(node)){
            wv[next] += wv[node];
            dfs(next);
        }
    }

}
