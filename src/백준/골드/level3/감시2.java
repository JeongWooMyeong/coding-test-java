package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 감시2 {
    static int n, m;
    static int[][] map;
    static List<int[]> cctv = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    cctv.add(new int[]{i,j});
                }
            }
        }

        dfs(0, map);

        System.out.println(min);
    }

    static void dfs(int depth, int[][] board){
        if(depth == cctv.size()){
            min = Math.min(min, count(board));
            return;
        }

        int x = cctv.get(depth)[0];
        int y = cctv.get(depth)[1];
        int type = board[x][y];

        for(int d=0;d<4;d++){
            int[][] copy = copy(board);

            if(type == 1){
                watch(copy, x, y, d);
            }else if(type == 2){
                watch(copy, x, y, d);
                watch(copy, x, y, (d+2)%4);
            }else if(type == 3){
                watch(copy, x, y, d);
                watch(copy, x, y, (d+1)%4);
            }else if(type == 4){
                watch(copy, x, y, d);
                watch(copy, x, y, (d+1)%4);
                watch(copy, x, y, (d+2)%4);
            }else if(type == 5){
                watch(copy, x, y, 0);
                watch(copy, x, y, 1);
                watch(copy, x, y, 2);
                watch(copy, x, y, 3);
            }

            dfs(depth+1, copy);
        }

    }

    static void watch(int[][] board, int x, int y, int dir){
        int nx = x;
        int ny = y;

        while(true){
            nx += dx[dir];
            ny += dy[dir];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) break;
            if(board[nx][ny] == 6) break;

            if(board[nx][ny] == 0){
                board[nx][ny] = -1;
            }
        }

    }

    static int count(int[][] board){
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static int[][] copy(int[][] board){
        int[][] newBoard = new int[n][m];

        for(int i=0;i<n;i++){
            newBoard[i] = board[i].clone();
        }

        return newBoard;
    }

}
