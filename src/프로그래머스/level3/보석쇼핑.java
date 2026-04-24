package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 보석쇼핑 {
    public static int[] solution(String[] gems){
        Set<String> gms = new HashSet<>();
        for(String gem : gems){
            gms.add(gem);
        }
        int[] answer = {0,0};
        int minValue = Integer.MAX_VALUE;

        int totalGem = gms.size();

        Map<String, Integer> gm = new HashMap<>();
        int left = 0; int right = 0;

        while(right < gems.length){
            gm.put(gems[right], gm.getOrDefault(gems[right], 0) + 1);
            right++;

            while(gm.size() == totalGem){
                if(minValue > right - left){
                    minValue = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                gm.put(gems[left], gm.get(gems[left]) - 1);
                if(gm.get(gems[left]) == 0){
                    gm.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        //String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems ={"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(solution(gems)));
    }

}
