package 이것이코딩테스트다2.그리디;

import java.util.*;

public class 큰수의법칙3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int first = arr[arr.length - 1];
        int second = arr[arr.length - 2];

        int cnt = (m / (k+1)) * k;
        int remain = m % (k+1);

        int result = 0;
        result += cnt * first;
        result += (m - cnt) * second;

        System.out.print(result);
    }
}
