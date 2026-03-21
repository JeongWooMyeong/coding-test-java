package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 단어수학4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        int[] weight = new int[26];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            words[i] = line;
            for(int j=0;j<line.length();j++){
                int idx = line.charAt(j) - 'A';
                weight[idx] += (int) Math.pow(10, line.length() - j - 1);
            }
        }

        Integer[] arr = new Integer[26];
        for(int i=0;i<weight.length;i++){
            arr[i] = weight[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int num = 9;
        int result = 0;

        for(int w : arr){
            if(w == 0) break;
            result += w * num;
            num--;
        }

        System.out.print(result);


    }
}
