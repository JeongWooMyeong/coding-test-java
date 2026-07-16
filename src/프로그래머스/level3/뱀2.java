package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀2 {

    static Queue<int[]> snake;
    static int[][] board;
    static int N, K;
    static int L;
    static Map<Integer, String> map;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        map = new HashMap<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //0 index 처리
            board[x-1][y-1] = 2;
        }

        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            map.put(time, d);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new LinkedList<>();
        snake.add(new int[]{0,0});
        int x = 0;
        int y = 0;
        int dir = 1;
        board[0][0] = 1;

        int time = 0;
        while(true){
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

            if(board[nx][ny] == 1) break;

            if(board[nx][ny] == 2){
                board[nx][ny] = 1;
                snake.add(new int[]{nx,ny});
            }else{
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
                board[nx][ny] = 1;
                snake.add(new int[]{nx,ny});
            }

            if(map.containsKey(time)){
                String dd = map.get(time);
                if(dd.equals("L")) dir = (dir + 3) % 4;
                if(dd.equals("D")) dir = (dir + 1) % 4;
            }

            x = nx;
            y = ny;

        }

        return time;
    }

}
