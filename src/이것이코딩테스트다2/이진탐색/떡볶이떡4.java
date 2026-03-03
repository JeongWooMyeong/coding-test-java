package 이것이코딩테스트다2.이진탐색;

import java.util.*;

public class 떡볶이떡4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //떡의 개수(N)와 요청한 떡의 길이 ((M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        //각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        //이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = arr[arr.length-1];
        //이진 탐색 수행 (반복)
        int result = 0;
        while(start <= end){
            long total = 0;
            int mid = (start + end) / 2;
            for(int i=0;i<n;i++){
                //잘랐을때의 떡의 양 계산
                if(arr[i] > mid) total += arr[i] - mid;
            }
            if(total < m){
                end = mid -1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
