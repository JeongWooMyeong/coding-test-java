package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 가사검색2 {
    static Map<Integer, List<String>> map;
    static Map<Integer, List<String>> reverseMap;

    public static int[] solution(String[] words, String[] queries){
        map = new HashMap<>();
        reverseMap = new HashMap<>();

        for(int i=0;i<words.length;i++){
            int len = words[i].length();
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if(!map.containsKey(len)){
                map.put(len, new ArrayList<>());
            }
            map.get(len).add(words[i]);
            if(!reverseMap.containsKey(len)){
                reverseMap.put(len, new ArrayList<>());
            }
            reverseMap.get(len).add(reverse);
        }

        //쿼리 사전순 오름차순 정렬
        for(int key : map.keySet()){
            Collections.sort(map.get(key));
            Collections.sort(reverseMap.get(key));
        }

        int[] answer = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            String query = queries[i];
            String reverseq = new StringBuilder(query).reverse().toString();
            int querylen = query.length();

            if(query.charAt(0) != '?'){
                String left = query.replace("?", "a");
                String right = query.replace("?", "z");

                //예외처리 안해줬네
                if(map.get(querylen) != null) {
                    answer[i] = countByRange(map.get(querylen), left, right);
                }else{
                    answer[i] = 0;
                }
            }else{
                String left = reverseq.replace("?", "a");
                String right = reverseq.replace("?", "z");

                if(map.get(querylen) != null) {
                    answer[i] = countByRange(reverseMap.get(querylen), left, right);
                }else{
                    answer[i] = 0;
                }
            }

        }


        return answer;
    }

    static int countByRange(List<String> list, String left, String right){
        int lowerbound = lowerBound(list, left);
        int upperbound = upperBound(list, right);

        return upperbound - lowerbound;
    }

    static int lowerBound(List<String> list, String target){
        int left = 0; int right = list.size();
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

    static int upperBound(List<String> list, String target){
        int left = 0; int right = list.size();
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
