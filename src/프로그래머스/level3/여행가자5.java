package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행가자5 {

    static int N,M;
    static int[] parent;
    static int[] schedule;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    union(i,j);
                }
            }
        }

        schedule = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        int root = findParent(schedule[0]);

        boolean found = false;

        for(int i=1;i<M;i++){
            if(findParent(schedule[i]) != root){
                found = true;
                break;
            }
        }


        if(!found) sb.append("YES");
        else sb.append("NO");

        System.out.println(sb);
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
