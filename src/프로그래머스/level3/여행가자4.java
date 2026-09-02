package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행가자4 {

    static int N,M;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int connected = Integer.parseInt(st.nextToken());
                if(connected == 1){
                    union(i,j);
                }
            }
        }

        int[] schedule = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        int root = findParent(schedule[0]);
        boolean found = true;
        for(int i=0;i<M;i++){
            if(root != findParent(schedule[i])){
                found = false;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(found) sb.append("YES");
        else sb.append("NO");

        System.out.print(sb);

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
