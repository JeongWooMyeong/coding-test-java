package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 뉴스클러스터링3 {
    static Map<String, Integer> map1;
    static Map<String, Integer> map2;

    public static int solution(String str1, String str2){
        map1 = makeMap(str1.toLowerCase());
        map2 = makeMap(str2.toLowerCase());

        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        int intersection = 0;
        int union = 0;

        for(String key : set){
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);

        }

        if(union == 0) return 65536;

        return (int)((double) intersection / union * 65536);

    }

    static Map<String, Integer> makeMap(String str){
        Map<String, Integer> result = new HashMap<>();

        for(int i=0;i<str.length()-1;i++){
            char current = str.charAt(i);
            char next = str.charAt(i+1);

            if(Character.isLetter(current) && Character.isLetter(next)) {
                String total = String.valueOf(current) + String.valueOf(next);
                result.put(total, result.getOrDefault(total, 0) + 1);
            }

        }

        return result;
    }

    public static void main(String[] args) throws Exception{
        String str1 = "FRANCE";
        String str2 = "french";

        System.out.println(solution(str1, str2));
    }

}
