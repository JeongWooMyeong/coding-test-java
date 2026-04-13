package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 숫자카드2_2 {
    static int N, M;
    static int[] arr;
    //static int[] cards;
    static List<Integer> cntlist = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            int count1 = lowerBound(0,arr.length,target);
            int count2 = upperBound(0,arr.length,target);
            cntlist.add(count2-count1);
        }
        //시간 초과 방지
        StringBuilder sb = new StringBuilder();
        for(int x : cntlist){
            sb.append(x).append(" ");
        }

        System.out.print(sb.toString().trim());

    }
    //이렇게 하면 안된다...
//    static int binarySearch(int start, int end, int target){
//        int count = 0;
//        while(start <= end){
//            int mid = (start + end) / 2;
//            if(arr[mid] == target) count++;
//            if(arr[mid] > target)
//        }
//
//        return count;
//    }
    static int lowerBound(int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            //값이 target보다 작을때 start 증가
            if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    static int upperBound(int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

}
