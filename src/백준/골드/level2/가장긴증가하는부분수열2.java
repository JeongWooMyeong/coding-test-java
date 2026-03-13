package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        for(int x : arr){
            int pos = Collections.binarySearch(lis, x);
            System.out.println(pos);
            if(pos < 0) pos = -(pos + 1);   //lower_bound 위치
            if(pos == lis.size()) lis.add(x);
            else lis.set(pos, x);
        }

        System.out.println(lis.size());
    }
}
