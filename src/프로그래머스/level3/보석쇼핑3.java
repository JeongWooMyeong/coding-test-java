package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
혼자 짜봤는데 실패
슬라이딩 윈도우 이해
 */

public class 보석쇼핑3 {
    static Set<String> set;

    public static int[] solution(String[] gems){
       set = new HashSet<>();

       for(String gem : gems){
           set.add(gem);
       }
       //보석배열 개수
       int n = gems.length;
       //토탈 보석 개수
       int totalGem = set.size();
       //보석 개수 담을 map
        Map<String, Integer> counter = new HashMap<>();
        //슬라이딩 윈도우
        int left = 0;
        int right = 0;
        //right - left 차이 (최소가 되는걸 구해야하므로)
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(true){
            //Map에 담은 보석이 총 보석 개수랑 같을때
            if(counter.size() == totalGem){
                if(minLen > right - left){
                    minLen = right - left;
                    answer[0] = left +1;
                    answer[1] = right;
                }

                //left 증가 (최소거리 더 있을 수 있으므로)
                counter.put(gems[left], counter.getOrDefault(gems[left],0)-1);
                if(counter.get(gems[left]) == 0) counter.remove(gems[left]);
                left++;

            }else{
                //다를때는 right 계속 이동
                if(right == n) break;
                counter.put(gems[right], counter.getOrDefault(gems[right],0)+1);
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
