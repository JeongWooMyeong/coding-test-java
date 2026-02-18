package 알고리즘정리;

/*
HashMap은 key-value 쌍을 저장하는 자료구조
key로 value를 빠르게 찾을 수 있음
중복 key는 허용되지 않음 (덮어쓰기 됨)
문자열 내 단어 빈도수 세기
배열 내 숫자 등장 횟수 카운트
그래프 인접 리스트 표현 (노드 -> 연결된 노드 리스트)
 */
import java.util.*;

public class HashMapExample {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

        //put : key-value 저장
        map.put("apple", 3);
        map.put("banana", 5);
        map.put("orange", 2);

        //get : key로 value 가져오기
        System.out.println("apple 개수: " + map.get("apple"));    //3

        //keySet : 모든 Key 순회
        for(String key : map.keySet()){
            System.out.println("과일: " + key + ", 개수: " + map.get(key));
        }

        //containsKey : 특정 key 존재 여부
        if(map.containsKey("banana")){
            System.out.println("바나나 있음!");
        }
    }
}
