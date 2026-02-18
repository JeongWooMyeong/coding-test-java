package 알고리즘정리;
/*
HashSet 중복없는 집합을 저장하는 자료구조
순서 없음
중복 자동 제거
배열에서 중복 제거
방문 여부 체크 (BFS/DFS에서 방문한 노드 기록)
소인수 분해 후 중복 없는 소인수 집합 만들기
 */
import java.util.*;

public class HashSetExample {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();

        //add: 원소 추가
        set.add(10);
        set.add(20);
        set.add(10);    //중복 -> 무시됨

        //contains : 특정 원소 존재 여부
        System.out.println("20 포함? " + set.contains(20));   //true

        //size : 원소 개수
        System.out.println("집합 크기 : " + set.size());    //2

        //순회
        for(int num : set){
            System.out.println("원소: " + num);
        }
    }
}
