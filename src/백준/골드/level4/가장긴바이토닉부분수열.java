package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[n]; //LIS (증가 부분 수열)
        int[] dec = new int[n]; //LDS (감소 부분 수열)

        //LIS 계싼 (왼쪽 -> 오른쪽)
        for(int i=0;i<n;i++){
            inc[i] = 1; //자기 자신만 포함하는 경우
            for(int j = 0; j< i;j++){
                if(arr[j] < arr[i]){
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        //LDS 계산
        for(int i=n-1;i>=0;i--){
            dec[i] = 1; //자기 자신만 포함
            for(int j=n-1;j>i;j--){
                if(arr[j] < arr[i]){
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        //바이토닉 수열 길이 계산
        int maxLen = 0;
        for(int i=0;i<n;i++){
            maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
        }

        System.out.println(maxLen);
    }
}
