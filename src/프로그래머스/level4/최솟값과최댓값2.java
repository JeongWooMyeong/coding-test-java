package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 최솟값과최댓값2 {

    static int N,M;
    static long[] arr;
    static long[] maxTree;
    static long[] minTree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        maxTree = new long[N * 4];
        minTree = new long[N * 4];

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(maxTree, Long.MIN_VALUE);
        Arrays.fill(minTree, Long.MAX_VALUE);

        build(1,1,N);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(min(1,1,N,start,end) + " " + max(1,1,N,start,end));
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void build(int node, int start, int end){
        if(start == end){
            maxTree[node] = arr[start];
            minTree[node] = arr[end];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        maxTree[node] = Math.max(maxTree[node * 2] ,maxTree[node * 2 + 1]);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);

    }

    static long min(int node, int start, int end, int left, int right){
        if(right < start || end < left) return Long.MAX_VALUE;

        if(left <= start && end <= right){
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(min(node * 2, start, mid, left, right), min(node * 2 + 1, mid+1, end, left, right));

    }

    static long max(int node, int start, int end, int left, int right){
        if(right < start || end < left) return Long.MIN_VALUE;

        if(left <= start && end <= right){
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(max(node * 2, start, mid, left, right), max(node * 2 + 1, mid+1, end, left, right));

    }

}
