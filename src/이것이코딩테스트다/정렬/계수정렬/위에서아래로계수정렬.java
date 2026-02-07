package 이것이코딩테스트다.정렬.계수정렬;

import java.util.*;

public class 위에서아래로계수정렬 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr= new int[N];

        int maxValue = 0;

        //입력받기
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
            maxValue = Math.max(maxValue, arr[i]);
        }

        //계수 배열 생성
        int[] count = new int[maxValue + 1];

        //각 숫자의 빈도수 기록
        for(int i=0;i<N;i++){
            count[arr[i]]++;
        }

        //큰 값부터 출력 (내림차순)
        for(int i=maxValue;i>=0;i--){
            for(int j=0;j<count[i];j++){
                System.out.print(i + " ");
            }
        }
    }
}
