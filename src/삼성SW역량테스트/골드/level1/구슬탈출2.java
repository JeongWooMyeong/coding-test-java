package 삼성SW역량테스트.골드.level1;

import java.util.*;
import java.io.*;

public class 구슬탈출2 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class State{
        int rx, ry;
        int bx, by;
        int depth;  //횟수

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int rx = 0; int ry = 0; int bx = 0; int by = 0;

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == 'R'){rx = i; ry = j; map[i][j] = '.'; }
                if(c == 'B'){bx = i; by = j; map[i][j] = '.'; }
            }
        }


        System.out.print(bfs(rx, ry, bx, by));




    }

    static int bfs(int rx, int ry, int bx, int by){
        Queue<State> q = new LinkedList<>();
        visited = new boolean[N][M][N][M];
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()){
            State cur = q.poll();
            if(cur.depth >= 10) return -1;

            for(int dir = 0;dir<4;dir++) {
                int[] red, blue;
                //방향에따라 움직이는 순서 고려해야 완벽
                //int[] red = move(rx2, ry2, dx[dir], dy[dir]);
                //int[] blue = move(bx2, by2, dx[dir], dy[dir]);
                if((dir == 0 && cur.rx < cur.bx) ||
                    (dir == 1 && cur.rx > cur.bx) ||
                    (dir == 2 && cur.ry < cur.by) ||
                    (dir == 3 && cur.ry > cur.by)) {
                    red = move(cur.rx, cur.ry, dx[dir], dy[dir]);
                    blue = move(cur.bx, cur.by, dx[dir], dy[dir]);
                }else{
                    blue = move(cur.bx, cur.by, dx[dir], dy[dir]);
                    red = move(cur.rx, cur.ry , dx[dir], dy[dir]);
                }


                //파란 구슬이 들어가면 안됌
                if(map[blue[0]][blue[1]] == 'O') continue;
                //빨간 구슬만 들어갔을때 depth (시행횟수 + 1)
                if(map[red[0]][red[1]] == 'O') return cur.depth + 1;

                //좌표가 같을때
                if(blue[0] == red[0] && blue[1] == red[1]){
                    //레드가 더 많이 움직였으면 뒤로 (근데 이게 어디에 존재하지?)
                    if(red[2] > blue[2]) {
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

        //return 안됐으면 빠란 구슬만 넣읈 ㅜ없음
        return -1;

    }

    static int[] move(int x, int y, int dx, int dy){
        int cnt = 0;
        while(map[x+dx][y+dy] != '#' && map[x][y] != 'O'){
            x += dx;
            y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }
}
