package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
LinkedHashMap
 */

public class 캐시7 {

    public static int solution(int cacheSize, String[] cities){
        Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.containsKey(city)){
                answer += 1;
            }else{
                if(cacheSize == cache.size()){
                    String oldest = cache.keySet().iterator().next();
                    cache.remove(oldest);
                }
                answer += 5;

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
