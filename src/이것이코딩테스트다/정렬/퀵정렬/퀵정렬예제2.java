package 이것이코딩테스트다.정렬.퀵정렬;

import java.util.*;

public class 퀵정렬예제2 {
    public static List<Integer> quickSort(List<Integer> arr){
        //원소가 1개 이하라면 그대로 반환
        if(arr.size() <= 1) return arr;

        int pivot = arr.get(0); //첫번째 원소를 피벗으로 설정
        List<Integer> tail = arr.subList(1, arr.size());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        //피벗 기준으로 분할
        for(int x : tail){
            if(x <= pivot) left.add(x);
            else right.add(x);
        }

        //재귀적으로 정렬 후 합치기
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(quickSort(left));
        sorted.add(pivot);
        sorted.addAll(quickSort(right));

        return sorted;
    }

    public static void main(String[] args){
        List<Integer> arr= Arrays.asList(5, 7, 9, 0, 3, 1, 6, 2, 4, 8);

        List<Integer> result = quickSort(arr);

        for(int x : result){
            System.out.print(x + " ");
        }
    }
}
