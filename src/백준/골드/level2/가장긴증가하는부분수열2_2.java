package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열2_2 {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : arr){
            int pos = BinarySearch(x, list);
            if(pos == list.size()){
                list.add(x);
            }else {
                list.set(pos, x);
            }
        }

        System.out.print(list.size());
    }

    public static int BinarySearch(int value, List<Integer> list){
        int start = 0;
        int end = list.size();

        while(start < end){
            int mid = (start + end) / 2;
            if(list.get(mid) < value) start = mid +1;
            else end = mid;
        }

        return start;
    }

}
