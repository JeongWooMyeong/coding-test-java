package 알고리즘정리;

import java.util.*;

/*
Compartor 규칙
음수 (-) : a가 b보다 앞에 옴
양수 (+) : a가 b보다 뒤에 옴
0 -> 순서 유지
 */

public class CompartorExample {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);

        //오름차순 정렬 (작은 값이 앞으로)
        Collections.sort(numbers, (a,b) -> a - b);
        System.out.println("오름 차순: " + numbers);

        //내림차순 정렬 (큰 값으로 앞으로)
        Collections.sort(numbers, (a,b) -> b-a);
        System.out.println("내림차순: " + numbers);

        //절댓값 기준 정렬
        Collections.sort(numbers, (a,b) -> Math.abs(a) - Math.abs(b));
        System.out.println("절댓값 기준: " + numbers);

        //절댓값 같으면 큰 수가 앞으로 오도록
        Collections.sort(numbers, (a,b) ->{
            int diff = Math.abs(a) - Math.abs(b);
            if(diff == 0){
                return b-a; //큰수가 앞으로
            }
            return diff;
        });

        System.out.println("절댓갑 + tie-breaker" + numbers);
    }
}
