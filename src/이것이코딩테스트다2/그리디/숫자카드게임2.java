package 이것이코딩테스트다2.그리디;

import java.util.*;

public class 숫자카드게임2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //행의 개수
        int m = sc.nextInt();   //열의 개수
        int result = 0;

        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            int min_value = 10001;
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
                min_value = Math.min(min_value, arr[i][j]);
            }
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}
