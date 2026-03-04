package 백준.실버.level5;

import java.util.*;

public class 숫자카드 {
    public static int n,m;
    public static int[] input;
    public static int[] check;  //숫자 카드 인지 확인

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
//            System.out.print(binarySearch(0, n-1, a, input) +" ");
            sb.append(binarySearch(0, n-1, a, input)).append(" ");
        }

        System.out.println(sb);

    }

    public static int binarySearch(int start, int end, int target, int[] arr){
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return 1;
            else if(arr[mid] > target) end = mid-1;
            else start = mid + 1;
        }

        return 0;
    }

}
