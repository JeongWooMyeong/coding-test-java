package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숫자카드2 {

    static int N, M;
    static int[] cards;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(cards, target)).append(" ");
        }


        System.out.println(sb.toString().trim());
    }

    static int binarySearch(int[] cards, int target){
        int left = 0;
        int right = cards.length-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(cards[mid] == target) return 1;

            if(cards[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return 0;
    }

}
