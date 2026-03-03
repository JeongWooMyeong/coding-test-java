package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 두배열의원소교체4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i=0;i<k;i++){
            int a = arr1[i];
            int b = arr2[i];

            if(a < b){
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
            }else break;
        }

        int result = 0;
        for(int i=0;i<arr1.length;i++){
            result += arr1[i];
        }

        System.out.println(result);

    }
}
