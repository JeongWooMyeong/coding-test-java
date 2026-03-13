package 백준.골드.level4;

import java.util.*;

public class NQUEEN {
    static int n;
    static int[] board; //board[row] = col (row행에 col열에 퀸을 놓음)
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        backtrack(0);
        System.out.println(count);
    }

    //row번째 행에 퀸을 놓는 함수
    static void backtrack(int row){
        if(row == n){
            //모든 행에 퀸을 놓았으면 해답 하나 완성
            count++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(row, col)){
                board[row] = col;   //row 행에 col열에 퀸 놓기
                backtrack(row+1);   //다음 행으로 진행
            }
        }
    }

    //현재 (row, col)에 퀸을 놓을 수 있는지 검사
    static boolean isSafe(int row, int col){
        for(int i=0;i<row;i++){
            //같은 열에 이미 퀸이 있는 경우
            if(board[i] == col) return false;
            //대각선에 퀸이 있는 경우 (행차이 == 열차이)
            if(Math.abs(row - i) == Math.abs(col - board[i])) return false;
        }
        return true;
    }
}
