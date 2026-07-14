package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 가사검색7 {

    static Map<Integer, List<String>> edges;
    static Map<Integer, List<String>> reversed;

    public static int[] solution(String[] words, String[] queries){

        edges = new HashMap<>();
        reversed = new HashMap<>();

        for(int i=0;i<words.length;i++){
            int len = words[i].length();
            String reverse = new StringBuilder(words[i]).reverse().toString();

            edges.putIfAbsent(len, new ArrayList<>());
            reversed.putIfAbsent(len, new ArrayList<>());

            edges.get(len).add(words[i]);
            reversed.get(len).add(reverse);
        }

        for(int key : edges.keySet()){
            Collections.sort(edges.get(key));
            Collections.sort(reversed.get(key));
        }

        int[] answer = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int len = queries[i].length();
            String reverse = new StringBuilder(queries[i]).reverse().toString();

            if(queries[i].charAt(0) != '?'){
                String left = queries[i].replace("?", "a");
                String right = queries[i].replace("?", "z");

                if(edges.get(len) == null){
                    answer[i] = 0;
                }else {
                    answer[i] = CountByRange(left, right, edges.get(len));
                }
            }else{
                String left = reverse.replace("?", "a");
                String right = reverse.replace("?", "z");

                if(reversed.get(len) == null){
                    answer[i] = 0;
                }else {
                    answer[i] = CountByRange(left, right, reversed.get(len));
                }
            }

        }

        return answer;
    }

    static int CountByRange(String left, String right, List<String> list){
        int lowerbound = lowerbound(left, list);
        int upperbound = upperbound(right, list);

        return upperbound - lowerbound;
    }

    static int lowerbound(String target, List<String> list){
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

    static int upperbound(String target, List<String> list){
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
