package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;

public class 가사검색 {
    //단어 길이별로 분류
    static Map<Integer, List<String>> wordsMap = new HashMap<>();
    static Map<Integer, List<String>> reversedMap = new HashMap<>();

    public static void main(String[] args){
        //예시 입력
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        //단어 길이별로 저장
        for(String word : words){
            int len = word.length();
            wordsMap.putIfAbsent(len, new ArrayList<>());
            reversedMap.putIfAbsent(len, new ArrayList<>());
            wordsMap.get(len).add(word);
            //reverse는 이거 이렇게 만들 수 있는지 처음 암
            reversedMap.get(len).add(new StringBuilder(word).reverse().toString());
        }

        //정렬
        for(int len : wordsMap.keySet()){
            Collections.sort(wordsMap.get(len));
            Collections.sort(reversedMap.get(len));
        }

        //쿼리 처리
        for(String query : queries){
            int result = countByQuery(query);
            System.out.println(query + " -> " + result);
        }
    }

    //쿼리 처리 함수
    static int countByQuery(String query){
        int len = query.length();
        if(!wordsMap.containsKey(len)) return 0;

        //와일드 카드가 앞에 오는지 뒤에 오는지 확인
        if(query.charAt(0) != '?'){
            //접미사 와일드카드 -> 앞부분 고정
            String left = query.replace('?', 'a');
            String right = query.replace('?', 'z');
            return countRange(wordsMap.get(len), left, right);
        }else{
            //접두사 와일드 카드 -> 뒷부분 고정
            String reversedQuery = new StringBuilder(query).reverse().toString();
            String left = reversedQuery.replace('?', 'a');
            String right = reversedQuery.replace('?', 'z');
            return countRange(reversedMap.get(len), left, right);
        }
    }

    //이진 탐색으로 범위 내 개수 세기
    static int countRange(List<String> list, String left, String right){
        return upperBound(list, right) - lowerBound(list, left);
    }

    static int lowerBound(List<String> list, String target){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(list.get(mid).compareTo(target) >= 0) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    static int upperBound(List<String> list, String target){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(list.get(mid).compareTo(target) > 0) high = mid;
            else low = mid + 1;
        }
        return low;
    }

}
