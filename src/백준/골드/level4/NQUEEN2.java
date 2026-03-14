package 백준.골드.level4;

import java.util.*;

public class NQUEEN2 {
    static int n;
    static int count = 0;
    static boolean[] col;   //열체크
    static boolean[] diag1; //오른쪽 아래 대각선 (row + col)
    static boolean[] diag2; //왼쪽 아래 대각선 (row-col + N-1)

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        col = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];

        backtrack(0);
        System.out.println(count);
    }

    public static void backtrack(int row){
        if(row == n){
            count++;
            return;
        }

        for(int c=0;c<n;c++){
            if(!col[c] && !diag1[row+c] && !diag2[row - c + n]){
                //퀸 놓기
                col[c] = diag1[row + c] = diag2[row - c + n] = true;

                backtrack(row + 1);

                //퀸 제거
                col[c] = diag1[row + c] = diag2[row - c + n] = false;
            }
        }
    }
}
