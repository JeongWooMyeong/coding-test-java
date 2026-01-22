package 이것이코딩테스트다.그리디;

import java.util.*;
import java.io.*;

public class 큰수의법칙3_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //첫째줄 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //N개의 배열
        int M = Integer.parseInt(st.nextToken()); //M 몇 더하기
        int K = Integer.parseInt(st.nextToken()); //K번 반복 x

        //두번째 줄 -> 배열
        st = new StringTokenizer(br.readLine());
        int[] ia = new int[N];

        for(int i=0;i<N;i++){
            ia[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ia);

        int first = ia[N-1];
        int second = ia[N-2];

        //가장 큰수가 더해지는 횟수, 패턴이 (K+1) 만큼 반복된다.. 핵심
        int count = (M / (K+1)) * K;
        count += (M % (K+1));

        //초기화
        int result = 0;
        result += count * first;
        result += (M - count) * second;

        System.out.println(result);

    }

}
