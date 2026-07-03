package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 표현가능한이진트리4
{

    public static int[] solution(long[] numbers){
        int[] answer = new int[numbers.length];

        int idx = 0;
        for(long num : numbers){

            String binary = Long.toBinaryString(num);

            int size = 1;
            while(size < binary.length()){
                size = 2 * size + 1;
            }

            binary = "0".repeat(size - binary.length()) + binary;


            if(check(binary)){
                answer[idx++] = 1;
            }else{
                answer[idx++] = 0;
            }

        }

        return answer;
    }

    static boolean check(String binary){

        if(binary.length() == 1) return true;

        int mid = binary.length() / 2;
        char root = binary.charAt(mid);
        String left = binary.substring(0, mid);
        String right = binary.substring(mid+1);

        if(root == '0'){
            if(left.contains("1") || right.contains("1")) return false;
        }

        return check(left) && check(right);
    }

    public static void main(String[] args) throws Exception{
        long[] numbers = {7, 42, 5};
        System.out.println(Arrays.toString(solution(numbers)));
    }


}
