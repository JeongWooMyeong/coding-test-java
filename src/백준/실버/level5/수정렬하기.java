package 백준.실버.level5;

import java.util.*;
import java.io.*;

public class 수정렬하기 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int x : arr){
            sb.append(x).append("\n");
        }

        System.out.print(sb);
    }

}
