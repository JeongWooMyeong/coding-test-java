package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 문자열뒤집기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int count0 = 0;
        int count1 = 0;
        int[] arr = new int[line.length()];


        for(int i=0;i<line.length();i++){
            arr[i] = line.charAt(i) - '0';
        }

        if(arr[0] == 1){
            count1++;
        }else{
            count0++;
        }

        for(int i=0;i<arr.length-1;i++){
            if(arr[i] != arr[i+1]){
                if(arr[i] == 1){
                    count1++;
                }else{
                    count0++;
                }
            }
        }

        System.out.print(Math.min(count0, count1));

    }
}
