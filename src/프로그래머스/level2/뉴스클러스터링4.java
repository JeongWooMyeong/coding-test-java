package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 뉴스클러스터링4 {

    static Map<String, Integer> map1;
    static Map<String, Integer> map2;
    static int intersection;
    static int union;

    public static int solution(String str1, String str2){
        map1 = makeMap(str1);
        map2 = makeMap(str2);
        Set<String> set1 = new HashSet<>();
        set1.addAll(map1.keySet());
        set1.addAll(map2.keySet());

        intersection = 0;
        union = 0;


        for(String str : set1){


            int cnt1 = map1.getOrDefault(str, 0);
            int cnt2 = map2.getOrDefault(str, 0);

            intersection += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);

        }

        if(union == 0) return 65536;

        return (int)(((double)intersection / union) * 65536);
    }

    static Map<String, Integer> makeMap(String str){
        Map<String, Integer> result = new HashMap<>();
        str = str.toLowerCase();

        for(int i=0;i<str.length()-1;i++){
            char current = str.charAt(i);
            char next = str.charAt(i+1);

            if(Character.isLetter(current) && Character.isLetter(next)){
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
