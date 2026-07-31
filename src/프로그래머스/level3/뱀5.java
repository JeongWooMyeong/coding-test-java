package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀5 {

    static int N, K;
    static int[][] board;
    static int L;
    static Map<Integer, String> dirs;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> snake;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            board[a][b] = 2;    //사과 위치
        }

        L = Integer.parseInt(br.readLine());
        dirs = new HashMap<>();

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            dirs.put(sec, dir);
        }

        System.out.println(simulate());

    }


    static int simulate(){
        snake = new LinkedList<>();
        snake.add(new int[]{0,0});
        int dir = 1;
        int time = 0;

        int x = 0;
        int y = 0;
        board[x][y] = 1;    //뱀 위치

        while(true){
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

            if(board[nx][ny] != 2){
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }

            if(board[nx][ny] == 1) break;

            snake.add(new int[]{nx,ny});
            board[nx][ny] = 1;

            if(dirs.containsKey(time)){
                String dd = dirs.get(time);
                if("L".equals(dd)) dir = (dir + 3) % 4;
                if("D".equals(dd)) dir = (dir + 1) % 4;
            }

            x = nx;
            y = ny;

        }

        return time;
    }

}
