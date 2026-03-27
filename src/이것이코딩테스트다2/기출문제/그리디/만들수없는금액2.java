package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 만들수없는금액2 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int target = 1;
        for(int x : arr){
            if(target < x){
                break;
            }

            target += x;
        }

        System.out.println(target);
    }
}
