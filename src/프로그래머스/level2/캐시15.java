package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 캐시15 {

    static Map<String, Integer> map;
    static int answer = 0;

    public static int solution(int cacheSize, String[] cities){
        map = new LinkedHashMap<>(cacheSize, 0.75f, true);
        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            city = city.toLowerCase();

            if(map.containsKey(city)){
                map.get(city);
                answer += 1;
            }else{
                if(cacheSize == map.size()){
                    String oldest = map.keySet().iterator().next();
                    map.remove(oldest);
                }

                map.put(city, 1);
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
