package 이것이코딩테스트다2.기출문제.그리디;

/*
두가지 방법 준비
1. 조합식 이용
2. 브루트 포스 이용
 */
import java.util.*;
import java.io.*;

public class 볼링공고르기2 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(arr[i] != arr[j]) result++;
            }
        }

        System.out.print(result);


    }
}
