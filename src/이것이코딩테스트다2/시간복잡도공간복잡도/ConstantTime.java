package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;

public class ConstantTime {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40};
        //특정 인덱스 접근 -> 항상 한번에 끝남
        System.out.println("3번째 값 " + arr[2] );

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        //해시맵 조회도 O(1)
        System.out.println("apple 개수: " + map.get("apple"));
    }
}
