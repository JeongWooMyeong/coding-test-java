package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열2 {

    static int N;
    static int[] arr;
    static int[] tail;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tail = new int[N];
        int size = 0;

        for(int x : arr){
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
            if(left == size){
                size++;
            }

        }

        System.out.println(size);
    }

}
