package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
LinkedHashMap 이용
Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);
마지막 param access order = true이렇게 했을때 get, put하면 해당 건 뒤로 감 (최신 사용)
 */

public class 캐시3 {
    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.containsKey(city)){
                cache.remove(city);
                cache.put(city, 1);
                answer += 1;
            }else{
                answer += 5;
                if(cacheSize == cache.size()){
                    String oldest = cache.keySet().iterator().next();
                    cache.remove(oldest);
                }

                cache.put(city, 1);
            }

        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }
}
