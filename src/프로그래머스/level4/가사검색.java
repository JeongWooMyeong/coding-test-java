package 프로그래머스.level4;

import java.util.*;
import java.io.*;

/*
그냥 길이별로 안하고 다 넣고
query 할때 길이별로 넣으면 불필요한 반복이 많아서 시간초과 발생
-> 길이별로 단어 정리해야할듯?
 */

public class 가사검색 {
    static List<String> list;
    static List<String> reverseList;

    public static int[] solution(String[] words, String[] queries){
        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        //String word 다 일단 정방향, 역방향 다 담기
        for(String word : words){
            list.add(word);
            reverseList.add(new StringBuilder(word).reverse().toString());
        }

        //오름 차순 정렬 (이진탐색)
        Collections.sort(list);
        Collections.sort(reverseList);

        int[] answer = new int[queries.length];

        int idx = 0;
        for(String query : queries){
            List<String> list2 = new ArrayList<>();

            if(query.charAt(0) != '?'){
                String left = query.replace("?", "a");
                String right = query.replace("?", "z");

                for(String str : list){
                    if(str.length() == query.length()) list2.add(str);
                }

                answer[idx] = countByRange(list2, left, right);

            }else{
                String reverse = new StringBuilder(query).reverse().toString();

                String left = reverse.replace("?", "a");
                String right = reverse.replace("?", "z");

                for(String str : reverseList){
                    if(str.length() == query.length()) list2.add(str);
                }

                answer[idx] = countByRange(list2, left, right);

            }

            idx++;

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
