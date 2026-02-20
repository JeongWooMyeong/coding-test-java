package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;

/*
O(nlogn) - 정렬 알고리즘
퀵소트, 머지소트, 힙소트
언제 Integer를 쓰면 좋은가?
- 정렬 기준을 바꾸고 싶을 때 (예: 내림차순 정렬).
- null을 허용해야 할 때.
- List<Integer> 같은 컬렉션에 담아야 할 때.
- Streams나 Comparator를 적극 활용할 때.

 */

public class NLogNTime {
    public static void main(String[] args){
        Integer[] arr = {5, 2, 9, 1, 7};

        //Arrays.sort -> 평균 O(n log n)
        Arrays.sort(arr, (a,b) -> b - a);
        System.out.println("정렬 결과 : "  + Arrays.toString(arr));
    }
}
