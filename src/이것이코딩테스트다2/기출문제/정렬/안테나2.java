package 이것이코딩테스트다2.기출문제.정렬;

import java.util.*;
import java.io.*;

/*
정렬해서 중앙값 구하면 그게 최솟값
 */

public class 안테나2 {
    static int N;
    static int[] houses;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        houses = new int[N];
        for(int i=0;i<N;i++){
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);
        //보통 중앙값 구할때 N-1 사용 (홀수 ,짝수)
        System.out.println(houses[(N-1) / 2]);


    }

}
