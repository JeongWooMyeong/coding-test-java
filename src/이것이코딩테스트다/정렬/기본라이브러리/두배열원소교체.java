package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

public class 두배열원소교체 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //배열크기
        int K = sc.nextInt(); //교체횟수

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        //배열 A 입력
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }

        //배열 B 입력
        for(int i=0;i<N;i++){
            B[i] = sc.nextInt();
        }

        //A 오름차순 정렬
        Arrays.sort(A);

        //B 내림차순 정렬
        Arrays.sort(B, Comparator.reverseOrder());

        //K번 교체 수행
        for(int i=0;i<K;i++){
            if(A[i] < B[i]){
                //swap
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            }else{
                break;
            }
        }

        //결과 배열 A의 합
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += A[i];
        }

        System.out.println(sum);

    }
}
