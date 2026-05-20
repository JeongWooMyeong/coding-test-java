package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
LinkedHashMAp을 이용한 캐시 문제 구현
이걸로 전에 풀어봤었는데 손에 익숙치 않았음
그리고 이건 accessOrder = true하면 자동으로 그 사이즈 되면 삭제 됌
 */

public class 캐시5 {

    public static int solution(int cacheSize, String[] cities){
        //75
        Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);

        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.containsKey(city)){
                answer += 1;
            }else{
                answer += 5;
                if(cacheSize == cache.size()){
                    String oldest = cache.keySet().iterator().next();
                    cache.remove(oldest);
                }
            }

            cache.put(city, 1);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }

}
