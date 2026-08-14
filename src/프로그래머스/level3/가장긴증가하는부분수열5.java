package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열5 {

    static int N;
    static int[] arr;
    static int[] tail;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tail = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //prev[i] : arr[i] 바로 앞에 오는 LIS 원소의 인덱스
        int[] prev = new int[N];
        //길이가 i+1 인 LIS의 마지막 원소 인덱스
        int[] index = new int[N];

        Arrays.fill(prev, -1);

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

            if(left > 0){
                prev[i] = index[left - 1];
            }

            index[left] = i;

            if(left == size){
                size++;
            }

        }

        int[] result = new int[size];

        int cur = index[size-1];

        for(int i=size-1;i>=0;i--){
            result[i] = arr[cur];
            cur = prev[cur];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(size).append("\n");

        for(int x : result){
            sb.append(x).append(" ");
        }

        System.out.println(sb);


    }

}
