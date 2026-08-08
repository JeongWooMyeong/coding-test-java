package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 호텔대실10 {

    static int[] prefix;
    static int maxEnd;
    static int answer;

    public static int solution(String[][] book_time){
        answer = Integer.MIN_VALUE;
        maxEnd = Integer.MIN_VALUE;

        for(String[] book : book_time){
            int end = toMin(book[1]) + 10;
            maxEnd = Math.max(maxEnd, end);
        }

        prefix = new int[maxEnd+1];

        for(String[] book : book_time){
            int start = toMin(book[0]);
            int end = toMin(book[1]) + 10;

            prefix[start] += 1;
            prefix[end] -= 1;
        }

        for(int i=1;i<=maxEnd;i++){
            prefix[i] += prefix[i-1];
        }

        for(int i=1;i<=maxEnd;i++){
            answer = Math.max(answer, prefix[i]);
        }

        return answer;

    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    public static void main(String[] args) throws Exception{
        String[][] book_time = {{"15:00","17:00"},{"16:40","18:20"},{"14:20","15:20"},{"14:10","19:20"},{"18:20","21:20"}};

        System.out.println(solution(book_time));
    }


}
