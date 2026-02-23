package 알고리즘정리2;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args){
        //HashSet 선언 : 요소 타입은 String
        HashSet<String> set = new HashSet<>();

        //add(): 값 추가
        set.add("사과");
        set.add("바나나");
        set.add("포도");
        set.add("사과");  //중복된 값은 무시됨

        //출력 : 중복된 사과는 한번만 저장됨
        System.out.println("HashSet 내용 : "+ set);

        //contains() : 특정값 존재 여부 확인
        if(set.contains("바나나")){
            System.out.println("바나나 있음!");
        }

        //remove() : 특정 값 삭제
        set.remove("포도");
        System.out.println("포도 삭제 후 : " + set);

        //size() : 요소 개수 확인
        System.out.println("현재 크기 : " + set.size());

        //전체 순회 (순서 없음)
        System.out.println("전체 출력:");
        for(String item : set){
            System.out.println(item);
        }

        //clear() 전체 삭제
        set.clear();
        System.out.println("전체 삭제 후 : " + set);
    }
}
