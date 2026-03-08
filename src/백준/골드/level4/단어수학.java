package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 단어수학 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] weight = new int[26];//알파벳 가중치
        for(int i=0;i<n;i++){
            String word = br.readLine();
            int len = word.length();
            for(int j=0;j<len;j++){
                char c = word.charAt(j);
                weight[c - 'A'] += Math.pow(10, len - j - 1);
            }
        }

        //가중치 내림차순 정렬
        Integer[] arr = new Integer[26];
        for(int i=0;i<26;i++) arr[i] = weight[i];
        Arrays.sort(arr, Collections.reverseOrder());

        int num = 9;
        int result = 0;
        for(int w : arr){
            if(w == 0) break;
            result += w * num;
            num--;
        }

        System.out.println(result);
    }

}
