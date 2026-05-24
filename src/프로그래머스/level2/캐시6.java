package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 캐시6 {

    public static int solution(int cacheSize, String[] cities){
        Deque<String> dq = new ArrayDeque<>();
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            city = city.toLowerCase();
            //큐에 city 있을대
            if(dq.contains(city)){
                //해당 city 삭제
                dq.remove(city);
                //최근 사용된것이므로 마지막에 다시 넣어줌
                dq.addLast(city);
                //cache hit느 1점
                answer += 1;
            }else{
                //cachesize가 = dq.size()
                if(cacheSize == dq.size()){
                    //사용안된 처음 삭제
                    dq.removeFirst();
                }
                //마지막에 넣기
                dq.addLast(city);
                //cache miss는 5
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
