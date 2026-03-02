package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 두배열의원소교체3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //N과 K를 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        //배열 A의 모든 원소를 입력받기
        Integer[] a = new Integer[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        //배열 B의 모든 원소를 입력받기
        Integer[] b = new Integer[n];
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }

        //배열 A는 오름차순 정렬
        Arrays.sort(a);
        //배열 B는 내림차순 정렬
        Arrays.sort(b, Collections.reverseOrder());

        //첫번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
        for(int i=0;i<k;i++){
            //A의 원소가 B의 원소보다 작은 경우
            if(a[i] < b[i]){
                //두 원소를 교체
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            //A의 원소가 B의 원소보다 크거나 같을때, 반복문 탈출
            else break;
        }

        long result = 0;
        for(int i=0;i<n;i++){
            result += a[i];
        }
        System.out.println(result);
    }
}
