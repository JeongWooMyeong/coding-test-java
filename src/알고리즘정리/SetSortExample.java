package 알고리즘정리;
import java.util.*;
/*
Set 정렬
직접은 불가 -> List로 변환 후 정렬
 */
public class SetSortExample {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 2, 9, 1));

        //List로 변환
        List<Integer> list = new ArrayList<>(set);

        //오름차순 정렬
        Collections.sort(list, (a, b) -> a - b);
        System.out.println("Set -> List 오름차순: " + list);

        //내림차순
        Collections.sort(list, (a,b) -> b- a);
        System.out.println("Set -> List 내림차순 :" + list);
    }
}
