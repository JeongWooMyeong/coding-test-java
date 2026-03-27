package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 모험가길드2 {
    static int N;
    static int[] arr;
    static int answer =0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for(int i=0;i<N;i++){
            cnt++;
            if(cnt >= arr[i]){
                answer += 1;
                cnt = 0;
            }
        }
        System.out.print(answer);



    }

}
