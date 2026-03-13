package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        Queue<Integer> q = new LinkedList<>();

        int sum = arr[0];
        for(int i=1;i<n;i++){
            sum += arr[i];
            q.offer(sum);
        }

        int result = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            result += a;
        }

        System.out.print(result);

    }
}
