package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 구간곱구하기2 {

    static int N,M,K;
    static long[] arr;
    static long[] tree;
    static long mod = 1000000007;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N*4];

        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1,1,N);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            if(command == 1){
                update(1,1,N,b,value);
            }else{
                sb.append(multiply(1,1,N,b,(int)value)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void build(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % mod;
    }

    static void update(int node, int start, int end, int index, long value){
        if(start == end){
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if(index <= mid){
            update(node * 2, start, mid, index, value);
        }else{
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % mod;

    }

    static long multiply(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 1;

        if(left <=start && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;

        return (multiply(node * 2, start, mid, left, right)
                * multiply(node * 2 + 1, mid + 1, end, left, right)) % mod;

    }

}
