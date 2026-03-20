package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 알파벳 {
    static int R;
    static int C;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};    //상하좌우
    static int[] dy = {0, 0, -1, 1};
    //static String result = "";
    static int maxlen = 0;

    /*
    지금까지 지나온 모든 칸에 적혀있는 알파벳 -> String으로 처리

     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            //st = new StringTokenizer(br.readLine());
            String line = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = line.charAt(j);
            }
        }

        visited[0][0] = true;
        dfs(0, 0, "" + board[0][0]);

        System.out.print(maxlen);
    }

    static void dfs(int x, int y, String path){
        maxlen = Math.max(maxlen, path.length());
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            if(!visited[nx][ny] && !path.contains(String.valueOf(board[nx][ny]))){

                visited[nx][ny] = true;
                dfs(nx, ny, path + board[nx][ny]);
                visited[nx][ny] = false;
            }

        }
    }

}
