package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

public class 위에서아래로2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //데이터 개수 입력
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        //데이터 입력
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }

        //내림차순 정렬
        arr.sort(Comparator.reverseOrder());

        //결과 출력
        for(int x : arr){
            System.out.print(x + " ");
        }

    }
}
