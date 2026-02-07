package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;
import java.io.*;

public class 위에서아래로 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        String result = "";

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=arr.length-1;i>=0;i--){
            result += arr[i] + " ";
        }

        System.out.print(result);

    }
}
