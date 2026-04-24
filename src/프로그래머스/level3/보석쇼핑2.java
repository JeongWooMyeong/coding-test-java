package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 보석쇼핑2 {
    public static int[] solution(String[] gems) {
        Set<String> gms = new HashSet<>();
        for (String gem : gems) {
            gms.add(gem);
        }
        int totalGem = gms.size();
        int left = 0;
        int right = 0;
        int[] answer = {0,0};   //start, end;

        Map<String, Integer> gemMap = new HashMap<>();

        int minValue = Integer.MAX_VALUE;

        while(right < gems.length){
            //오른쪽 증가
            gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
            right++;

            while(gemMap.size() == totalGem){
                if(minValue > right - left){
                    minValue = right - left;
                    answer[0] = left+1;
                    answer[1] = right;
                }

                //
                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                //left++;
                if(gemMap.get(gems[left]) == 0){
                    gemMap.remove(gems[left]);
                }
                left++;

            }

        }

        return answer;


    }

    public static void main(String[] args) throws Exception{
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }

}
