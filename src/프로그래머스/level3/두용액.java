package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 두용액 {

    static int N;
    static int min;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int[] answer = new int[2];

        while(left < right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min){
                min = sum;
                answer[0] = arr[left];
                answer[1] = arr[right];

            }

            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int x : answer){
            sb.append(x).append(" ");
        }

        System.out.println(sb);

    }

}
