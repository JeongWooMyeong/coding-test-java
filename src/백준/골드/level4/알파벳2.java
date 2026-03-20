package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 알파벳2 {
    static int R, C;
    static char[][] board;
    static boolean[] used = new boolean[26];    //알파벳 사용 여부
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxLen = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i=0;i<R;i++){
            String line = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = line.charAt(j);
            }
        }

        used[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(maxLen);
    }

    static void dfs(int x, int y, int depth){
        maxLen = Math.max(maxLen, depth);

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            int alpha = board[nx][ny] - 'A';
            if(!used[alpha]){
                used[alpha] = true;
                dfs(nx, ny, depth + 1);
                used[alpha] = false; //백트래킹
            }
        }
    }
}
