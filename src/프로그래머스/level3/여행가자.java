package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행가자 {

    static int N,M;
    static int[] parent;
    static int[] travel;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        travel = new int[M];
        for(int i=0;i<M;i++){
            travel[i] = Integer.parseInt(st.nextToken()) -1;
        }

        int root = findParent(travel[0]);
        boolean possible = true;

        for(int i=0;i<M;i++){
            if(root != findParent(travel[i])){
                possible = false;
                break;
            }
        }

        String answer = "";
        if(!possible) answer = "NO";
        else answer = "YES";

        System.out.println(answer);


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
