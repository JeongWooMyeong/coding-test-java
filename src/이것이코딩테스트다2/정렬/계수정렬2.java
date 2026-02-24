package 이것이코딩테스트다2.정렬;

import java.util.*;

/*
계수정렬 : 특정한 조건이 부합할때만 사용할 수 있지만 매우
빠른 정렬 알고리즘
일반적으로 큰데이ㅓ와 가장 작은 데이터의 차이가 1000000을 넘어가지 않을때 효과적으로 사용
 */

public class 계수정렬2 {
    public static final int MAX_VALUE = 9;

    public static void main(String[] args){
        int n= 15;
        //모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        //모든 범위를 포함하는 배열 선언 (모든 값은 0으로 초기화)
        int[] cnt = new int[MAX_VALUE + 1];

        for(int i=0;i<n;i++){
            cnt[arr[i]] += 1;   //각 데이터에 해당하는 인덱스의 값 증가
        }
        for(int i=0;i<MAX_VALUE;i++){
            for(int j=0;j<cnt[i];j++){
                System.out.print(i + " ");  //띄어쓰기를 기준으로 등장한 횟수만큼 인덱스 출력
            }
        }
    }
}
