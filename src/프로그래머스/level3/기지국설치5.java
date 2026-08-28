package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기지국설치5 {

    public static int solution(int n, int[] stations, int w){
        int cover = 2 * w + 1;
        int start = 1;
        int answer = 0;

        for(int i=0;i<stations.length;i++){
            int left = stations[i] - w;
            if(start < left) {
                int gap = left - start;
                answer += (gap + cover - 1) / cover;
            }

            start = stations[i] + w + 1;
        }

        if(start <= n){
            int gap = n - start + 1;
            answer += (gap + cover -1) / cover;
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
