package 백준.플레티넘.level5;

import java.util.*;
import java.io.*;

/*
이전 LIS는 N의 범위가 작아서 DP 가능
근데 이거는 1000000까지이므로 이진탐색 (NlogN)으로 푸어야 가능

 */

public class 가장긴증가하는부분수열 {
    static int N;
    static int[] prev;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();  //LIS 담을 리스트
    static List<Integer> idx = new ArrayList<>();   //lis idx 담을 리스트

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        prev = new int[N];

        //Arrays.fill(arr, 1);
        Arrays.fill(prev, -1);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            int x = arr[i];
            int p = lowerBound(list, x);
            if(list.size() == p){
                list.add(x);
                idx.add(i);
            }else{
                list.set(p, x);
                idx.set(p, i);
            }
            if(p > 0) prev[i] = idx.get(p-1);
        }

        int lastIdx = idx.get(idx.size()-1);
        List<Integer> result = new ArrayList<>();

        while(lastIdx != -1){
            result.add(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        Collections.reverse(result);

        System.out.println(list.size());
        for(int x : result){
            System.out.print(x + " ");
        }



    }

    static int lowerBound(List<Integer> list, int target){
        int left = 0; int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < target){
                left = mid +1;
            }else{
                right = mid;
            }

        }

        return left;

    }




}
