package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 가사검색8 {

    static Map<Integer, List<String>> edges;
    static Map<Integer, List<String>> reversed;

    public static int[] solution(String[] words, String[] queries){

        edges = new HashMap<>();
        reversed = new HashMap<>();

        for(String word : words){
            int len = word.length();
            String reverse = new StringBuilder(word).reverse().toString();

            edges.putIfAbsent(len, new ArrayList<>());
            reversed.putIfAbsent(len, new ArrayList<>());

            edges.get(len).add(word);
            reversed.get(len).add(reverse);

        }

        for(int key : edges.keySet()){
            Collections.sort(edges.get(key));
            Collections.sort(reversed.get(key));
        }

        int[] answer = new int[queries.length];
        int idx = 0;
        for(String query : queries){
            int len = query.length();
            String reverse = new StringBuilder(query).reverse().toString();

            if(query.charAt(0) != '?'){
                String left = query.replace("?", "a");
                String right = query.replace("?", "z");

                if(edges.get(len) == null){
                    answer[idx] = 0;
                }else{
                    answer[idx] = CountByRange(left, right, edges.get(len));
                }

            }else{
                String left = reverse.replace("?", "a");
                String right = reverse.replace("?", "z");

                if(reversed.get(len) == null){
                    answer[idx] = 0;
                }else{
                    answer[idx] = CountByRange(left, right, reversed.get(len));
                }

            }

            idx++;
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
