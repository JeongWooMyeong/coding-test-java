package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 가사검색3 {

    static Map<Integer, List<String>> map;
    static Map<Integer, List<String>> reverseMap;

    public static int[] solution(String[] words, String[] queries){
        map = new HashMap<>();
        reverseMap = new HashMap<>();

        int[] answer = new int[queries.length];


        for(String word : words){
            String reverse = new StringBuilder(word).reverse().toString();
            int len = word.length();
            map.putIfAbsent(len, new ArrayList<>());
            reverseMap.putIfAbsent(len, new ArrayList<>());

            map.get(len).add(word);
            reverseMap.get(len).add(reverse);

        }

        //이진탐색을 위하여 정렬 필수
        for(int key : map.keySet()){
            Collections.sort(map.get(key));
            Collections.sort(reverseMap.get(key));
        }

        int i = 0;
        for(String query : queries){
            String reverseq = new StringBuilder(query).reverse().toString();
            int len = query.length();

            if(query.charAt(0) != '?'){
                String left = query.replace("?", "a");
                String right = query.replace("?", "z");

                //int idx = CountByRange(map, left, right);
                if(map.get(len) == null){
                    answer[i] = 0;
                }else{
                    answer[i] = CountByRange(map.get(len), left, right);
                }

            }else{
                String left = reverseq.replace("?", "a");
                String right = reverseq.replace("?", "z");

                //int idx = CountByRange(reverseMap, left, right);
                if(reverseMap.get(len) == null){
                    answer[i] = 0;
                }else{
                    answer[i] = CountByRange(reverseMap.get(len), left, right);
                }
            }

            i++;

        }

        return answer;
    }

    static int CountByRange(List<String> list, String left, String right){
        int lowerbound = lowerbound(list, left);
        int upperbound = upperbound(list, right);

        return upperbound - lowerbound;
    }

    static int lowerbound(List<String> list, String target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid).compareTo(target) >= 0){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        return left;
    }

    static int upperbound(List<String> list, String target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid).compareTo(target) > 0){
                right = mid;
            }else{
                left = mid + 1;
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
