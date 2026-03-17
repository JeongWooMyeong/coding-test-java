package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 나무자르기2 {
    static int N, M;//나무의 수 N, 가져가려고 하는 나무의 길이
    static int[] trees;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);  //최대값 여기서 구하면 디는구나
        }

        //Arrays.sort(trees);
        //max = trees[N-1];   //나무 길의 max 값

        System.out.println(binarySearch(0, max, M));

    }

    static int binarySearch(int start, int end, int target){

        int result = 0;
        while(start <= end){
            int total = 0;
            int mid = (start + end) / 2;
            for(int i=0;i<N;i++){
                //int remain = trees[i] - mid;
                //if(remain < 0) remain = 0;
                total += Math.max(trees[i] - mid, 0);
            }
            if(total >= target){
                result = mid;
                start = mid + 1;

            }else{
                end = mid - 1;
            }
        }

        return result;
    }

}
