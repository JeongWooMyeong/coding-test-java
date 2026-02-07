package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

public class 기본라이브러리예제3 {
    public static void main(String[] args){
        List<String> arr = new ArrayList<>(Arrays.asList("바나나", "사과", "당근"));

        //문자열 길이를 기준으로 오름차순 정렬
        arr.sort(Comparator.comparingInt(String::length));

        //결과 출력
        for(String s : arr){
            System.out.print(s + " ");
        }
    }
}
