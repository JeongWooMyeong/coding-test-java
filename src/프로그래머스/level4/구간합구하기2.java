package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 구간합구하기2 {

    static int N, M, K;
    static long[] arr;
    static long[] tree;

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
            int c = Integer.parseInt(st.nextToken());

            if(command == 1){
                update(1,1,N,b,c);
            }else{
                sb.append(sum(1,1,N,b,(int)c)).append("\n");
            }
        }

        System.out.println(sb);

    }

    static void build(int node, int start, int end){
        //한개만 있나?
        if(start == end){
            tree[node] = arr[start];
            return;
        }
        //중간값은?
        int mid = (start + end) / 2;
        //왼쪽, 오른쪽 저장
        build(node * 2, start, mid);
        build(node * 2 +1, mid+1, end);
        //부모 노드 저장
        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    static void update(int node, int start, int end, int index, long value){
        //변경할 위치 도착
        if(start == end){
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        //왼
        if(index <= mid){
            update(node * 2, start, mid, index, value);
        }

        //오
        else{
            update(node * 2 + 1, mid+1, end, index, value);
        }

        //부모 다시 계산
        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    static long sum(int node, int start, int end, int left, int right){
        //완전히 범위 밖
        if(right < start || end < left){
            return 0;
        }

        //현재 구간이 원하는 범위 안에 완전히 포함
        if(left <= start && end <= right){
            return tree[node];
        }

        //부분적으로 겹침
        int mid = (start + end) / 2;

        return sum(node * 2, start, mid, left, right)
                + sum(node * 2 + 1, mid +1, end, left, right);
    }

}
