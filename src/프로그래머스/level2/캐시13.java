package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 캐시13 {

    static Map<String ,Integer> cache;

    public static int solution(int cacheSize, String[] cities){
        cache = new LinkedHashMap<>(cacheSize, 0.75f, true);
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.containsKey(city)){
                cache.get(city);    //get or put하면 자동으로 뒤로감 accesorder = true이면
                answer += 1;
            }else{
                if(cacheSize == cache.size()){
                    String oldest = cache.keySet().iterator().next();
                    cache.remove(oldest);
                }
                cache.put(city, 1);
                answer += 5;
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
