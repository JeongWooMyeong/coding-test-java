package 백준.골드.level1;

import java.util.*;
import java.io.*;

public class K번째수4 {
    static int N;
    static int K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    //배열의 크기;
        K = Integer.parseInt(br.readLine());    //K번째 수

        //배열로 만들어서 하면 이 문제는 풀 수 없음
        //k번째 수 를 이용해서 풀어야함
        int left = 0;
        int right = K;
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;

            for(int i=1;i<=N;i++){
                count += Math.min(mid/i, N);
            }

            //카운트가 k보다 크거나 같으면 값을 더 줄여서 확인
            if(count >= K){
                result= mid;
                right = mid - 1;
            }else{
                //아니라면 left 증가
                left = mid + 1;
            }


        }

        System.out.print(result);
    }

}
