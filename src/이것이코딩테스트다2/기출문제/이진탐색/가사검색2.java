package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 가사검색2 {
    static Map<Integer, List<String>> wordsMap = new HashMap<>();
    static Map<Integer, List<String>> reversedMap = new HashMap<>();

    public static void main(String[] args) throws Exception{
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        //단어별 길이로 나눔
        for(String word : words){
            int len = word.length();
            //초기 hashmap 비어있으면 설정
            wordsMap.putIfAbsent(len, new ArrayList<>());
            reversedMap.putIfAbsent(len, new ArrayList<>());
            wordsMap.get(len).add(word);
            reversedMap.get(len).add(new StringBuilder(word).reverse().toString());
        }

        //길이에 따른 단어에 대해서 오름차순 정렬
        for(int len : wordsMap.keySet()){
            Collections.sort(wordsMap.get(len));
            Collections.sort(reversedMap.get(len));
        }

        for(String query : queries){
            System.out.println(query + " -> " + countByQuery(query));
        }

    }

    //해당 query에 대해서 찾기 (접두사, 접미사 주의)
    static int countByQuery(String query){
        int len = query.length();
        //만약 해당하는 len에 대한게 없으면 0 반환
        if(!wordsMap.containsKey(len)) return 0;

        //와일드 카드가 앞에 있는지 뒤에 있는지 확인
        if(query.charAt(0) != '?'){
            String left = query.replace('?', 'a');  //?를 사전맨앞 a로 치환
            String right = query.replace('?', 'z'); //?를 사진 뒤 z로 치환
            List<String> list = wordsMap.get(len);
            return countByRange(left, right, list);
        }else{
            String reversedQuery = new StringBuilder(query).reverse().toString();
            String left = reversedQuery.replace('?', 'a');
            String right = reversedQuery.replace('?', 'z');
            List<String> reversedList = reversedMap.get(len);
            return countByRange(left, right, reversedList);
        }

    }

    static int countByRange(String left, String right, List<String> list){
        return upperBound(right, list) - lowerBound(left, list);
    }

    static int upperBound(String target, List<String> list){
        int low = 0; int high = list.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(list.get(mid).compareTo(target) > 0) high = mid;
            else low = mid + 1;
        }

        return low;
    }

    static int lowerBound(String target, List<String> list){
        int low = 0; int high = list.size();
        while(low < high){
            int mid = (low+high) / 2;
            if(list.get(mid).compareTo(target) >= 0) high = mid;
            else low = mid + 1;
        }

        return low;
    }

}
