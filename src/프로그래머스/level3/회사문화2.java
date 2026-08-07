package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 회사문화2 {

    static ArrayList<ArrayList<Integer>> edges;
    static int[] wv;
    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        wv = new int[n+1];

        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1 ) continue;
            edges.get(parent).add(i);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            wv[num] = value;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(wv[i]).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

    static void dfs(int start){
        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);
            wv[next] += wv[start];
            dfs(next);
        }
    }

}
