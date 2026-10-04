package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장긴바이토닉부분수열2 {

    static int N;
    static int[] arr;
    static int[] left;
    static int[] right;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        left = new int[N+1];
        right = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(left, 1);

        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                if(arr[j] < arr[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        Arrays.fill(right, 1);

        for(int i=N;i>=1;i--){
            for(int j=i+1;j<=N;j++){
                if(arr[j] < arr[i]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        answer = 0;

        for(int i=1;i<=N;i++){
            answer = Math.max(answer, left[i] + right[i] -1);
        }

        System.out.println(answer);

    }

}
