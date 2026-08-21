package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 최솟값과최댓값 {

    static int N,M;
    static long[] arr;
    static long[] mintree;
    static long[] maxtree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        mintree = new long[N*4];
        maxtree = new long[N*4];

        Arrays.fill(mintree, Long.MAX_VALUE);
        Arrays.fill(maxtree, Long.MIN_VALUE);

        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1,1,N);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long min = min(1,1,N,a,b);
            long max = max(1,1,N,a,b);

            sb.append(min + " " + max).append("\n");
        }

        System.out.println(sb);

    }

    static void build(int node, int start, int end){
        if(start == end){
            maxtree[node] = arr[start];
            mintree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid+1, end);

        maxtree[node] = Math.max(maxtree[node * 2], maxtree[node * 2 + 1]);
        mintree[node] = Math.min(mintree[node * 2], mintree[node * 2 + 1]);
    }

    static long min(int node, int start, int end, int left, int right){
        if(right < start || end < left) return Long.MAX_VALUE;

        if(left <= start && end <= right){
            return mintree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(min(node * 2, start, mid, left, right), min(node * 2 +1, mid +1, end, left, right));
    }

    static long max(int node, int start, int end, int left, int right){
        if(right < start || end < left) return Long.MIN_VALUE;

        if(left <= start && end <= right){
            return maxtree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(max(node * 2, start, mid, left, right), max(node * 2 +1, mid +1, end, left, right));
    }

}
