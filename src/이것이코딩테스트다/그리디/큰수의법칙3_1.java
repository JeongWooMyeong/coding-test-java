package 이것이코딩테스트다.그리디;

import java.util.*;
import java.io.*;

public class 큰수의법칙3_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ia = new int[N];

        for(int i=0;i<N;i++){
            ia[i] = Integer.parseInt(st.nextToken());
        }
        //작은수 -> 큰수 정렬 오름차순 정렬
        Arrays.sort(ia);

        int data1 = ia[N-1]; //제일큰수
        int data2 = ia[N-2]; // 두번째로 큰수
        while(true) {
            for (int j = 0; j < K; j++) {
                if(M == 0) break;
                answer += data1;
                M--;
            }

            if(M==0) break;
            answer += data2;
            M--;


        }

        System.out.println(answer);

    }
}