package 백준.골드.level1;

import java.io.*;
import java.util.*;

public class 구슬탈출 {
    static int n, m;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0, -1, 1};

    static class State{
        int rx, ry, bx, by, depth;
        State(int rx, int ry, int bx, int by, int depth){
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R') { rx =i; ry =j; board[i][j]='.';}
                if(board[i][j] == 'B') { bx = i; by = j; board[i][j]='.';}

            }
        }

        visited = new boolean[n][m][n][m];
        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by){
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()){
            State cur = q.poll();
            if(cur.depth >= 10) return 0;

            for(int dir=0;dir<4;dir++){
                int[] red = move(cur.rx, cur.ry, dx[dir], dy[dir]);
                int[] blue = move(cur.bx, cur.by, dx[dir], dy[dir]);

                //파란 구슬이 들어가면 실패
                if(board[blue[0]][blue[1]] == 'O') continue;
                //빨간 구슬만 구머에 들어가면 성공
                if(board[red[0]][red[1]] == 'O') return 1;

                //두 구슬이 같은 위치라면, 이동 거리를 비교해서 조정 (문제에는 없는 로직)
                if(red[0] == blue[0] && red[1] == blue[1]){
                    if(red[2] > blue[2]){   //red가 더 많이 움직였으면 뒤로
                        red[0] -= dx[dir];
                        red[1] -= dy[dir];

                    }else{
                        blue[0] -= dx[dir];
                        blue[1] -= dy[dir];
                    }
                }

                if(!visited[red[0]][red[1]][blue[0]][blue[1]]){
                    visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                    q.offer(new State(red[0], red[1], blue[0], blue[1], cur.depth+1));
                }

            }
        }
        return 0;
    }

    //구슬을 특정 방향으로 끝까지 이동시키는 함수
    static int[] move(int x, int y, int dx, int dy){
        int cnt = 0;
        while(board[x+dx][y+dy] != '#' && board[x][y] != 'O'){
            x += dx;
            y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }

}
