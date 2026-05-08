package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 삼각달팽이2 {

    public static int[] solution(int n){
        int[][] triangle = new int[n][n];
        int x = -1;
        int y = 0;
        int value = 1;
        /*
        i = 방향 상태 (언제 꺾을지)
        j = 이동 횟수
        x,y = 실제 위치
         */
        for(int i=0;i<n;i++){
            //몇번 반복할지
            for(int j=i;j<n;j++){
                //아래
                if(i % 3 == 0){
                    x++;
                //오른쪽
                }else if(i % 3 == 1){
                    y++;
                //대각선 위
                }else{
                    x--;
                    y--;
                }

                triangle[x][y] = value++;
            }
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

    public static void main(String[] args) throws Exception{
        int n= 6;
        System.out.println(Arrays.toString(solution(n)));
    }

}
