package 백준.실버.level3;

import java.util.*;

public class 체스판다시칠하기
{
    static char[][] board;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        board = new char[n][m];

        for(int i=0;i<n;i++){
            board[i] = sc.next().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        for(int r=0;r<=n-8;r++){
            for(int c=0;c<=m-8;c++){
                answer = Math.min(answer, repaintCost(r, c));
            }
        }

        System.out.println(answer);


    }

    static int repaintCost(int sr, int sc){
        int cntW = 0;   //왼쪽 위가 W인 경우
        int cntB = 0;   //왼쪽 위가 B인 경우

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char cur = board[sr + i][sc + j];
                if((i + j) % 2 == 0){
                    if(cur != 'W') cntW++;
                    if(cur != 'B') cntB++;
                }else{
                    if(cur != 'B') cntW++;
                    if(cur != 'W') cntB++;
                }
            }
        }

        return Math.min(cntW, cntB);

    }

}
