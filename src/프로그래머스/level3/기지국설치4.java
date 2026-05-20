package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기지국설치4 {

    public static int solution(int n, int[] stations, int w){
        int answer = 0;
        int cover = 2 * w + 1; //커버 범위 칸

        int start = 1;
        for(int i=0;i<stations.length;i++){
            int left = stations[i] - w;
            if(start < left){
                int gap = left - start;
                answer += (gap + cover - 1) / cover;  //올림처리
            }
            start = stations[i] + w + 1;
        }

        //혹시 모르니 마지막 기지국 처리
        //만약 기지국이 앞에 있고 뒤에는 처리 안될수도 있음
        if(start <= n){
            int gap = n - start + 1;
            answer += (gap + cover - 1) / cover;
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
