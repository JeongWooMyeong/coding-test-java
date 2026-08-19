package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열7 {

    static int N;
    static int[] arr;
    static int[] tail;
    static int[] index;
    static int[] prev;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tail = new int[N];
        index = new int[N];
        prev = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int size = 0;

        for(int i=0;i<N;i++){
            int x = arr[i];

            int left = 0;
            int right = size;

            while(left < right){
                int mid = (left + right) / 2;

                if(tail[mid] < x){
                    left = mid + 1;
                }else{
                    right = mid;
                }

            }

            tail[left] = x;

            if(left > 0) prev[i] = index[left-1];

            index[left] = i;

            if(size == left){
                size++;
            }
        }

        int[] result = new int[size];
        int cur = index[size-1];

        for(int i=size-1;i>=0;i--){
            result[i] = arr[cur];
            cur = prev[cur];
        }

        sb = new StringBuilder();
        sb.append(size).append("\n");
        for(int x : result){
            sb.append(x).append(" ");
        }

        System.out.println(sb);

    }

}
