package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 부분수열의합2 {

    static int N,S;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int mask=1;mask<(1<<N);mask++){
            int sum = 0;
            for(int i=0;i<N;i++){
                if((mask & (1<<i)) != 0){
                    sum += arr[i];
                }
            }

            if(sum == S){
                answer++;
            }
        }

        System.out.println(answer);
    }

}
