package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 보석쇼핑4 {

    static Map<String, Integer> map;
    static int n;

    public static int[] solution(String[] gems){
        int totalgem = new HashSet<>(Arrays.asList(gems)).size();
        map = new HashMap<>();
        n = gems.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(true){
            if(totalgem == map.size()){
                if(right - left < minLen){
                    minLen = right - left;
                    answer[0] = left+1;
                    answer[1] = right;
                }

                map.put(gems[left], map.getOrDefault(gems[left], 0) - 1);

                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }

                left++;

            }else{
                if(right == n) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }

}
