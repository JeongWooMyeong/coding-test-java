package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 나무자르기2 {
    static int N, M;
    static int[] woods;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        woods = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            woods[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(woods);

        int left = 0;
        int right = woods[woods.length-1];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int remain = 0;
            for(int i=0;i<woods.length;i++){
                if(woods[i] - mid > 0) {
                    remain += woods[i] - mid;
                }

            }

            if(remain >= M){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }

        System.out.println(answer);

    }

}
