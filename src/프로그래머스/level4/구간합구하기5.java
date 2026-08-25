package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 구간합구하기5 {

    static int N,M,K;
    static long[] arr;
    static long[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N*4];   //여유 있게

        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1,1,N);

        sb = new StringBuilder();

        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            if(cmd == 1){
                update(1,1,N,b,value);
            }else{
                sb.append(sum(1,1,N,b,(int)value)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void build(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid+1, end);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    static void update(int node, int start, int end, int index, long value){
        if(start == end){
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if(index <= mid){
            update(node * 2, start , mid, index, value);
        }else{
            update(node * 2 + 1, mid+1, end, index, value);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long sum(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        return sum(node * 2, start, mid, left, right)
                + sum(node * 2 + 1, mid +1, end, left, right);
    }

}
