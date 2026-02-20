package 알고리즘정리;

import java.util.*;

public class MapSortExample {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);

        //Key 기준 오름차순
        List<Map.Entry<String, Integer>> keyList = new ArrayList<>(map.entrySet());
        keyList.sort(Map.Entry.comparingByKey());
        System.out.println("Key 기준 오름 차순 : " + keyList);

        //Value 기준 오름차순
        List<Map.Entry<String, Integer>> valueList = new ArrayList<>(map.entrySet());
        valueList.sort(Map.Entry.comparingByValue());
        System.out.println("Value 기준 오름 차순 : " + valueList);

        //Value 기준 내림차순
        valueList.sort((a, b) -> b.getValue() - a.getValue());
        System.out.println("Value 기준 내림 차순: " + valueList);
    }
}
