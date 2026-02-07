package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

public class 위에서아래로3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
