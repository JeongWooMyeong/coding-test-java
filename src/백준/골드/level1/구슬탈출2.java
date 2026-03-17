package 백준.골드.level1;

import java.util.*;
import java.io.*;

public class 구슬탈출2 {
    static int n, m;
    static char[][] board;
    static boolean[][][][] visited; //rx, ry, bx, by 이동
    static int rx, ry, bx, by;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    //B, R 구슬 상태
    static class State{
        int rx;
        int ry;
        int bx;
        int by;
        int depth;

        public State(int rx, int ry, int bx, int by, int depth){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R'){
                    rx = i;
                    ry = j;
                    board[i][j] = '.';  //위치 상태만 중요하므로 빈칸 표시
                }else if(board[i][j] == 'B'){
                    bx = i;
                    by = j;
                    board[i][j] = '.';  //위치 상태만 중요하므로 빈칸 표시
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));


    }

    static int bfs(int rx, int ry, int bx, int by){
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()){
            State cur = q.poll();
            if(cur.depth >= 10) return 0;

            //4가지 방향 이동
            for(int d=0;d<4;d++){
                int[] red = move(cur.rx, cur.ry, dx[d], dy[d]);
                int[] blue = move(cur.bx, cur.by, dx[d], dy[d]);

                if(board[blue[0]][blue[1]] == 'O') continue;
                if(board[red[0]][red[1]] == 'O') return 1;

                //두 구슬이 같은 위치일때
                if(blue[0] == red[0] && blue[1] == red[1]){
                    if(red[2] > blue[2]){
                        red[0] -= dx[d];
                        red[1] -= dy[d];
                    }else{
                        blue[0] -= dx[d];
                        blue[1] -= dy[d];
                    }

                }

                if(!visited[red[0]][red[1]][blue[0]][blue[1]]){
                    visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                    q.offer(new State(red[0], red[1], blue[0], blue[1], cur.depth + 1));
                }


            }

        }
        return 0;
    }

    static int[] move(int x, int y, int dx, int dy){
        int cnt = 0;    //거리이동 개수
        //다음 칸이 벽 # 이 아니면 계속 이동 가능, 현재 칸이 구멍 O 아니며 계속 이동
        while(board[x+dx][y+dy] != '#' && board[x][y] != 'O'){
            x += dx;
            y += dy;
            cnt++;
        }

        return new int[]{x, y, cnt};
    }

}
