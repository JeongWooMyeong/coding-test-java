package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 회사문화3 {

    static int n,m;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] wv;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=n;i++) edges.add(new ArrayList<>());

        wv = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;
            edges.get(parent).add(i);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            wv[num] += value;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(wv[i]).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

    static void dfs(int start){
        for(int next : edges.get(start)){
            wv[next] += wv[start];
            dfs(next);
        }
    }

}
