package 백준.실버.level5;

import java.util.*;
import java.io.*;

public class 소트인사이드 {
    static Integer[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        arr = new Integer[st.length()];

        for(int i=0;i<arr.length;i++){
            arr[i] = st.charAt(i) - '0';
        }



        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(int c : arr){
            sb.append(c);
        }

        System.out.print(sb);
    }

}
