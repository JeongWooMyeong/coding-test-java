package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
경계로 했을때 완벽하게 답이 나오지 않음..

 */

public class 삼각달팽이 {

    public static int[] solution(int n){
        int[][] triangle = new int[n][n];

        int value = 1;

        int x1 = 0;
        int y1 = 0;
        int x2 = n-1;
        int y2 = n-1;
        while(value <= (n*(n+1))/2) {
            //위에서 아래
            for (int x = x1; x <= x2 && triangle[x][y1] == 0; x++) {
                triangle[x][y1] = value;
                value++;
            }

            y1++;

            //아래에서 오른쪽
            for (int y = y1; y <= y2 && triangle[x2][y] == 0; y++) {
                triangle[x2][y] = value;
                value++;
            }

            x2--;
            y2--;

            int y = y2;
            for (int x = x2; x > x1 && triangle[x][y] == 0; x--) {
                triangle[x][--y] = value;
                value++;
            }

            x1 += 2;
        }

        int[] answer = new int[(n*(n+1)/2)];

        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[idx++] = triangle[i][j];
            }
        }


        return answer;
    }

    public static void main(String[] arsg) throws Exception{
        int n = 6;
        System.out.println(Arrays.toString(solution(n)));
    }

}
