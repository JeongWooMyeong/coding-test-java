package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 최솟값과최댓값3 {

    static int N,M;
    static long[] mintree;
    static long[] maxtree;
    static long[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        mintree = new long[N*4];
        maxtree = new long[N*4];
        sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1,1,N);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(1,1,N,a,b) + " " + max(1,1,N,a,b)).append("\n");
        }

        System.out.print(sb);

    }

    static void build(int node, int start, int end){
        if(start == end){
            mintree[node] = arr[start];
            maxtree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2 , start , mid);
        build(node * 2 + 1, mid + 1, end);

        mintree[node] = Math.min(mintree[node*2], mintree[node*2+1]);
        maxtree[node] = Math.max(maxtree[node*2], maxtree[node*2+1]);

    }

    static long min(int node, int start, int end, int left, int right){
        if(right < start || end < left) return Long.MAX_VALUE;
        if(left<= start && end <= right) return mintree[node];

        int mid = (start + end) / 2;

        return Math.min(min(node * 2, start, mid, left, right),
                    min(node*2+1,mid+1, end, left, right));

    }


    static long max(int node, int start, int end, int left, int right){
        if(right < start || end < left) return Long.MIN_VALUE;
        if(left<= start && end <= right) return maxtree[node];

        int mid = (start + end) / 2;

        return Math.max(max(node * 2, start, mid, left, right),
                max(node*2+1,mid+1, end, left, right));

    }

}
