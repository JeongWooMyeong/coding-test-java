package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 숫자카드2 {
    static int N, M;
    static int[] totalcards;
    static int[] mycards;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        totalcards = new int[N];
        //전체 카드 수
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            totalcards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(totalcards);
        //내 카드
        M = Integer.parseInt(br.readLine());
        mycards = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            mycards[i] = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch1(0, N, mycards[i], totalcards) - binarySearch2(0, N, mycards[i], totalcards));
        }

    }

    static int binarySearch1(int start, int end, int target, int[] arr){

        while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] <= target) {
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }

        return start;
    }

    static int binarySearch2(int start, int end, int target, int[] arr){

        while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] < target) {
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }

        return start;
    }

}
