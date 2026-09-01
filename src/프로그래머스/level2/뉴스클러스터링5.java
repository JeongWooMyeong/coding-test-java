package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 뉴스클러스터링5 {

    static Map<String, Integer> map1;
    static Map<String, Integer> map2;
    static int intersection;
    static int union;

    public static int solution(String str1, String str2){
        map1 = makeMap(str1);
        map2 = makeMap(str2);

        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        intersection = 0;
        union = 0;

        for(String str : set){
            //int cnt1 = map1.get(str);
            //int cnt2 = map2.get(str);
            int cnt1 = map1.getOrDefault(str, 0);
            int cnt2 = map2.getOrDefault(str, 0);

            intersection += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);

        }

        if(union == 0) return 65536;

        return (int)(((double)intersection / union) * 65536);

    }

    static Map<String, Integer> makeMap(String str){
        Map<String, Integer> total = new HashMap<>();
        str = str.toLowerCase();

        for(int i=0;i<str.length()-1;i++){
            char cur = str.charAt(i);
            char next = str.charAt(i+1);

            if(Character.isLetter(cur) && Character.isLetter(next)){
                String key = String.valueOf(cur) + String.valueOf(next);
                total.put(key, total.getOrDefault(key, 0) + 1);
            }

        }

        return total;
    }

    public static void main(String[] args) throws Exception{
        String str1 = "handshake";
        String str2 = "shake hands";

        System.out.println(solution(str1, str2));
    }

}
