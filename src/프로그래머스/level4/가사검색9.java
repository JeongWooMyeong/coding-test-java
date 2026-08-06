package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 가사검색9 {

    static Map<Integer, List<String>> map;
    static Map<Integer, List<String>> reverseMap;

    public static int[] solution(String[] words, String[] queries){
        map = new HashMap<>();
        reverseMap = new HashMap<>();

        for(String word : words){
            int len = word.length();
            String reversed = new StringBuilder(word).reverse().toString();
            map.putIfAbsent(len, new ArrayList<>());
            reverseMap.putIfAbsent(len, new ArrayList<>());

            map.get(len).add(word);
            reverseMap.get(len).add(reversed);
        }

        for(int key : map.keySet()){
            Collections.sort(map.get(key));
            Collections.sort(reverseMap.get(key));
        }

        int[] answer = new int[queries.length];
        int idx = 0;

        for(String query : queries){
            String reversed = new StringBuilder(query).reverse().toString();
            int len = query.length();

            if(query.charAt(0) != '?'){
                String left = query.replace("?", "a");
                String right = query.replace("?", "z");

                if(map.get(len) == null){
                    answer[idx++] = 0;
                }else{
                    answer[idx++] = CountByRange(left,right,map.get(len));
                }


            }else{
                String left = reversed.replace("?", "a");
                String right = reversed.replace("?", "z");

                if(map.get(len) == null){
                    answer[idx++] = 0;
                }else{
                    answer[idx++] = CountByRange(left,right,reverseMap.get(len));
                }

            }

        }

        return answer;
    }

    static int CountByRange(String left, String right, List<String> list){
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

    public static void main(String[] args) throws Exception{
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(solution(words, queries)));
    }

}
