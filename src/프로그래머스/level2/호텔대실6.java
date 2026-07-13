package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 호텔대실6 {

    static int[] presum;
    static int maxEnd;

    public static int solution(String[][] book_time){
        maxEnd = Integer.MIN_VALUE;

        for(int i=0;i<book_time.length;i++){
            int end = toMin(book_time[i][1]) + 10;
            maxEnd = Math.max(maxEnd, end);
        }

        presum = new int[maxEnd + 2];

        for(String[] book : book_time){
            int start = toMin(book[0]);
            int end = toMin(book[1]) + 10;

            presum[start] += 1;
            presum[end] -= 1;

        }

        for(int i=1;i<=maxEnd;i++){
            presum[i] += presum[i-1];
        }

        int answer = 0;

        for(int i=1;i<=maxEnd;i++){
            answer = Math.max(answer, presum[i]);
        }

        return answer;
    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int M = Integer.parseInt(arr[0]) * 60;
        int S = Integer.parseInt(arr[1]);

        return M + S;
    }

    public static void main(String[] args) throws Exception{
        String[][] book_time = {{"15:00","17:00"},{"16:40","18:20"},{"14:20","15:20"},{"14:10","19:20"},{"18:20","21:20"}};

        System.out.println(solution(book_time));
    }

}
