package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class N2배열자르기 {

    //static long[][] map;

    public static int[] solution(int n, long left, long right){
        //map = new long[n][n];
        int[] answer = new int[(int)(right - left + 1)];

        int k = 0;
        for(long idx=left;idx<=right;idx++){
            long row = (idx / n);
            long col = (idx % n);

            answer[k++] = (int)Math.max(row,col) + 1;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        long left = 2;
        long right = 5;


        System.out.println(Arrays.toString(solution(n,left,right)));
    }

}
