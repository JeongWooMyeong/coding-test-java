package 프로그래머스.level2;

import java.util.*;
import java.io.*;


public class HINDEX2 {

    public static int solution(int[] citations){
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);

        for(int i=0;i<n;i++){
            //citations[i] 와 citations[i] 보다 큰 개수
            //둘다 만족해야하므로 min
            int h = Math.min(citations[i], n-i);
            //구한 h중에 최대값이므로 max
            answer = Math.max(answer, h);
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }

}
