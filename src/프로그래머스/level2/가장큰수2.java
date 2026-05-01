package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 가장큰수2 {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        //"0000" 인 경우 있음..
        if(arr[0].equals("0")) return "0";

        for(String str : arr){
            answer += str;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {6,10,2};
        System.out.println(solution(numbers));
    }


}
