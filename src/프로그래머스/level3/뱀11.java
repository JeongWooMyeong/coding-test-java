package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀11 {

    static int N,K,L;
    static int[][] board;
    static Map<Integer, String> dirs;
    static Deque<int[]> snake;
    static StringBuilder sb;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];
        dirs = new HashMap<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 2;
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());

            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            dirs.put(sec, dir);

        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new ArrayDeque<>();
        snake.addFirst(new int[]{1,1});
        board[1][1] = 1;

        int time = 0;
        int x = 1;
        int y = 1;
        int dir = 0;

        while(true){
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 1 || ny < 1 || nx > N || ny > N) break;

            if(board[nx][ny] != 2){
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }

            if(board[nx][ny] == 1) break;


            board[nx][ny] = 1;
            snake.addLast(new int[]{nx,ny});

            if(dirs.containsKey(time)){
                String direc = dirs.get(time);

                if("L".equals(direc)){
                    dir = (dir + 3) % 4;
                }else{
                    dir = (dir + 1) % 4;
                }

            }

            x = nx;
            y = ny;

        }

        return time;
    }

}
