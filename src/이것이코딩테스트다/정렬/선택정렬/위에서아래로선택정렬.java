package 이것이코딩테스트다.정렬.선택정렬;

import java.util.*;

public class 위에서아래로선택정렬 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        //선택정렬 (내림차순)
        for(int i=0;i<N-1;i++){
            int maxIdx = i;
            for(int j= i+1;j<N;j++){
                if(arr[j] > arr[maxIdx]){
                    maxIdx = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }

        //결과출력
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
