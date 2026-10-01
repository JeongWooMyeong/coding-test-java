package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 가사검색12 {

    static Map<Integer, List<String>> map;
    static Map<Integer, List<String>> reverseMap;
    static int[] answer;

    public static int[] solution(String[] words, String[] queries){
        map = new HashMap<>();
        reverseMap = new HashMap<>();

        for(String word : words){
            int length = word.length();
            String reverse = new StringBuilder(word).reverse().toString();

            map.putIfAbsent(length, new ArrayList<>());
            reverseMap.putIfAbsent(length, new ArrayList<>());

            map.get(length).add(word);
            reverseMap.get(length).add(reverse);

        }

        for(int key : map.keySet()){
            Collections.sort(map.get(key));
            Collections.sort(reverseMap.get(key));
        }

        answer = new int[queries.length];

        int idx = 0;
        for(String query : queries){
            String reverseq = new StringBuilder(query).reverse().toString();
            int length  =query.length();

            if(query.charAt(0) != '?'){

                String left = query.replace("?", "a");
                String right = query.replace("?", "z");

                if(map.containsKey(length)){
                    answer[idx++] = countByRange(left, right, map.get(length));
                }else{
                    answer[idx++] = 0;
                }
            }else{
                String left = reverseq.replace("?", "a");
                String right = reverseq.replace("?", "z");

                if(reverseMap.containsKey(length)){
                    answer[idx++] = countByRange(left, right, reverseMap.get(length));
                }else{
                    answer[idx++] = 0;
                }
            }
        }

        return answer;

    }

    static int countByRange(String left, String right, List<String> list){
        int lowerbound = lowerBound(left, list);
        int upperbound = upperBound(right, list);

        return upperbound - lowerbound;
    }

    static int lowerBound(String target, List<String> list){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid).compareTo(target) < 0){
                left = mid + 1;
            }else{
                right = mid;
            }

        }

        return left;

    }

    static int upperBound(String target, List<String> list){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid).compareTo(target) <= 0){
                left = mid + 1;
            }else{
                right = mid;
            }

        }

        return left;
    }

}
