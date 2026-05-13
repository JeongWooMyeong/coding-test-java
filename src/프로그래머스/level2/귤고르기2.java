package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 귤고르기2 {

    static Map<Integer, Integer> map;

    public static int solution(int k, int[] tangerine){
        int answer = 0;
        map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        int count = 0;

        for(int num : list){
            count += num;
            answer++;
            if(count >= k) break;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int k = 6;
        int[] tangerine = {1,3,2,5,4,5,2,3};

        System.out.println(solution(k, tangerine));
    }

}
