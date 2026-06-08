package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최고의집합 {

    public static int[] solution(int n, int s){

        if(n > s) return new int[]{-1};

        int[] answer=  new int[n];

        int q = s / n;
        int r = s % n;

        Arrays.fill(answer, q);

        for(int i=n-r;i<n;i++){
            answer[i]++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 2;
        int s = 9;
        System.out.println(Arrays.toString(solution(n,s)));
    }

}
