package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숫자카드 {

    static int N;
    static int[] cards;
    static int M;
    static int[] find;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            if(!binarySearch(target)) sb.append("0").append(" ");
            else sb.append("1").append(" ");
        }

        System.out.println(sb.toString());
    }

    static boolean binarySearch(int target){
        int left = 0;
        int right = cards.length-1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(cards[mid] == target) return true;

            if(cards[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        return false;
    }

}
