package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 표현가능한이진트리2 {

    public static int[] solution(long[] numbers){
        int[] answer = new int[numbers.length];

        for(int i=0;i<numbers.length;i++){
            String binary = Long.toBinaryString(numbers[i]);

            int size = 1;
            while(size < binary.length()){
                size = size * 2 + 1;
            }

            binary = "0".repeat(size - binary.length()) + binary;

            if(check(binary)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }

        }

        return answer;
    }

    static boolean check(String binary){
        if(binary.length() == 1) return true;

        int mid = (binary.length()) / 2;
        char root = binary.charAt(mid);
        String left2 = binary.substring(0, mid);
        String right2 = binary.substring(mid+1);

        if(root == '0'){
            if(left2.contains("1") || right2.contains("1")) return false;
        }

        return check(left2) && check(right2);
    }

    public static void main(String[] args) throws Exception{
        long[] numbers = {7, 42, 5};
        System.out.println(Arrays.toString(solution(numbers)));
    }

}
