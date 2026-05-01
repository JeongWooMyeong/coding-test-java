package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class HINDEX {
    public static int solution(int[] citations){
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        int max = citations[n-1];

        while(max > 0) {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < n; i++) {
                if(max <= citations[i]){
                    count1++;
                }else if(max >= citations[i]){
                    count2++;
                }

            }

            if(count1 >= max && count2 == n-count1) break;
            max--;
        }

        return max;

    }

    public static void main(String[] args) throws Exception{
        int[] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }

}
