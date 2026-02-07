package 이것이코딩테스트다.정렬.삽입정렬;

import java.util.*;

public class 위에서아래로삽입정렬 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr= new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        //삽입정렬 (내림차순)
        for(int i=1;i<N;i++){
            int key = arr[i];
            int j = i-1;
            //앞쪽으로 이동하면서 key보다 작은 값들을 뒤로 밀기
            while(j>=0 && arr[j] < key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        //결괴 출력
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
