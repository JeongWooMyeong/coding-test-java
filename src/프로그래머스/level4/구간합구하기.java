package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 구간합구하기 {

    static int N;
    static int M;
    static int K;

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

        //세그먼트 트리 만들기
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(command == 1){
                //b번째 값을 c로 변경
                update(1,1,N,b,c);
            }else{
                sb.append(sum(1,1,N,b,(int)c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void build(int node, int start, int end){
        //리프노드
        if(start == end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        //왼쪽
        build(node * 2, start, mid);

        //오른쩍
        build(node * 2 +1, mid +1, end);

        //부모 = 왼쪽 + 오른쪽
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void update(int node, int start, int end, int index, long value){
        if(start == end){
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        //index가 왼쪽에 있음
        if(index <= mid){
            update(node * 2, start, mid, index, value);
        }

        //index가 오른쪽에 있음
        else{
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        //자식이 변경됐으므로 부모도 다시 계산
        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    static long sum(int node, int start, int end, int left, int right){
        //완전히 범위 밖
        if(right < start || end < left){
            return 0;
        }

        //현재 구간이 원하는 범위 안에 완전 ㅣㅎ들어옴
        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;

        //왼쪽 _ 오른쪽
        return sum(node * 2, start, mid, left, right)
            + sum(node * 2 + 1, mid +1, end, left, right);
    }

}
