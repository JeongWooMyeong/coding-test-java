package 알고리즘정리2;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args){
        //HashMap 선언 : 키는 String, 값은 Integer
        HashMap<String, Integer> map = new HashMap<>();

        //put() : 값 추가 (키-값 쌍 저장)
        map.put("사과", 3);
        map.put("바나나", 2);
        map.put("포도", 5);

        //get() : 키로 값 가져오기
        System.out.println("사과 개수 : " + map.get("사과"));

        //getOrDefault() : 키가 없을때 기본값 반환
        System.out.println("오렌지 개수 : " + map.getOrDefault("오렌지", 0));   //출력 0

        //put() 을 이용한 값 수정
        // 기존값에 +1 해서 다시 저장
        map.put("사과", map.get("사과") + 1);   //사과 개수 3 -> 4로 변경
        System.out.println("사과 개수 수정 후 : " + map.get("사과"));

        //containsKey() : 특정 키 존재 여부 확인
        if(map.containsKey("바나나")){
            System.out.println("바나나 있음!");
        }

        //remove() : 특정 키 삭제
        map.remove("포도");   //포도 키 삭제
        System.out.println("포도 삭제 후 : " + map.get("포도"));   //출력 null

        //keySet() 모든 키 가져오기
        System.out.println("모든 키 출력:");
        for(String key : map.keySet()){
            System.out.println(key);
        }

        //values() 모든 값 가져오기
        System.out.println("모든 값 출력 : ");
        for(Integer value : map.values()){
            System.out.println(value);
        }

        //entrySet() : 키-값 쌍 전체 가져오기
        System.out.println("키-값 전체 출력: ");
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
