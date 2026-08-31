package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀7 {

    static int N,K,L;
    static Queue<int[]> snake;
    static int[][] board;
    static Map<Integer, String> map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        board = new int[N][N];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a-1][b-1] = 2;
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            map.put(sec, dir);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new LinkedList<>();
        snake.offer(new int[]{0,0});
        int dir = 1;
        int x = 0;
        int y = 0;
        int time = 0;

        board[x][y] = 1;

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

            snake.offer(new int[]{nx,ny});
            board[nx][ny] = 1;

            if(map.containsKey(time)){
                String d = map.get(time);
                if("L".equals(d)) dir = (dir + 3) % 4;
                else if("D".equals(d)) dir = (dir + 1) % 4;
            }

            x = nx;
            y = ny;
        }

        return time;
    }

}
