package 백준.실버.level2;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();

        for(int num : arr){
            int pos = lowerBound(lis, num);
            if(pos == lis.size()){
                lis.add(num);
            }else{
                lis.set(pos, num);
            }
        }

        System.out.println(lis.size());
    }

    //lowerBound : key 이상이 처음 나온ㄴ 위치 반
    static int lowerBound(List<Integer> arr, int key){
        int left = 0;
        int right = arr.size();
        while(left < right){
            int mid = (left+right) / 2;
            if(arr.get(mid) < key){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}
