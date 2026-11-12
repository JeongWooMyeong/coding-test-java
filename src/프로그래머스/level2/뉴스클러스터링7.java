package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 뉴스클러스터링7 {

    static int intersection;
    static int union;
    static Map<String, Integer> map1;
    static Map<String, Integer> map2;
    static Set<String> set;

    public static int solution(String str1, String str2){
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        map1 = makeMap(str1);
        map2 = makeMap(str2);

        set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        intersection = 0;
        union = 0;

        for(String str : set){
            int value1 = map1.getOrDefault(str, 0);
            int value2 = map2.getOrDefault(str, 0);

            intersection += Math.min(value1, value2);
            union += Math.max(value1, value2);

        }


        if(union == 0) return 65536;

        return (int)((double)intersection / union * 65536);

    }

    static Map<String, Integer> makeMap(String str){
        Map<String, Integer> result = new HashMap<>();

        str = str.toLowerCase();

        for(int i=0;i<str.length()-1;i++){
            int now = str.charAt(i);
            int next = str.charAt(i+1);

            if(Character.isLetter(now) && Character.isLetter(next)){
                String str2 = ""+now+next;

                result.put(str2, result.getOrDefault(str2, 0) + 1);
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
