package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 두배열원소교체 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //n과 k를 입력받기
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

        //배열 A는 오름 차순
        Arrays.sort(a);
        //배열 B는 내림차순
        Arrays.sort(b, Collections.reverseOrder());

        //
        for(int i=0;i<k;i++){
            if(a[i] < b[i]){
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }else break;
        }

        long result = 0;
        for(int i=0;i<n;i++){
            result += a[i];
        }
        System.out.println(result);
    }
}
