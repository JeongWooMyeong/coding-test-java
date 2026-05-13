package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기지국설치 {

    public static int solution(int n, int[] stations, int w){
        int coverage = 2*w + 1;
        int start = 1;
        int answer = 0;


        for(int s : stations){
            //int start = 1;
            int left = s - w;
            if(start < left){
                int gap = left - start;
                answer += (gap + coverage - 1) / coverage;
            }
            start = s + w + 1;
        }

        if(start <= n){
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int N = 11;
        int[] stations = {4,11};
        int W = 1;
        System.out.println(solution(N, stations, W));
    }

}
