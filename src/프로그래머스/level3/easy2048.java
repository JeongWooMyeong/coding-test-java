package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class easy2048 {

    static int N;
    static int[][] board;
    static int answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = Integer.MIN_VALUE;

        board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);

        System.out.println(answer);
    }

    static void dfs(int[][] board, int depth){
        if(depth == 5){
            answer = Math.max(answer, getMax(board));
            return;
        }

        for(int i=0;i<4;i++){
            int[][] next = move(board, i);
            dfs(next, depth+1);
        }
    }

    static int[][] move(int[][] board, int dir){
        int[][] newboard = new int[N][N];

        for(int i=0;i<N;i++){
            newboard[i] = board[i].clone();
        }

        //
        for(int i=0;i<N;i++){

            LinkedList<Integer> line = new LinkedList<>();
            // 줄 뽑기
            for(int j=0;j<N;j++){
                int value = 0;
                if(dir == 0) value = newboard[j][i];      // 위
                if(dir == 1) value = newboard[N-1-j][i];  // 아래
                if(dir == 2) value = newboard[i][j];      // 왼쪽
                if(dir == 3) value = newboard[i][N-1-j];  // 오른쪽
                if(value != 0) line.add(value);
            }
            //합치기
            LinkedList<Integer> merged = new LinkedList<>();
            while(!line.isEmpty()){
                int cur = line.poll();
                if(!line.isEmpty() && cur == line.peek()){
                    merged.add(cur * 2);
                    line.poll();
                }else{
                    merged.add(cur);
                }
            }
            //합친거 다시 넣기
            for(int j=0;j<N;j++){
                int value = j < merged.size() ? merged.get(j) : 0;
                if(dir == 0) newboard[j][i] = value;
                if(dir == 1) newboard[N-1-j][i] = value;
                if(dir == 2) newboard[i][j] = value;
                if(dir == 3) newboard[i][N-1-j] = value;

            }


        }

        return newboard;

    }

    static int getMax(int[][] board){
        int maxValue = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maxValue = Math.max(maxValue, board[i][j]);
            }
        }

        return maxValue;
    }

}
