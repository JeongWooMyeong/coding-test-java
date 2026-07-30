package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀4 {

    static int N, K, L;
    static int[][] board;
    static Map<Integer, String> dirs;
    static Queue<int[]> snake;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a-1][b-1] = 2;    //사과 위치
        }

        L = Integer.parseInt(br.readLine());
        dirs = new HashMap<>();
        snake = new LinkedList<>();

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            dirs.put(sec, dir);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake.add(new int[]{0,0});
        board[0][0] = 1;    //뱀의 위치
        int dir = 1;

        int x = 0;
        int y = 0;

        int time = 0;

        while(true){
            //시간 증가
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //범위 벗어났을때 게임 종료
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

            //사과 아닐때
            if(board[nx][ny] != 2){
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }
            //자기 자신 충돌 검사
            if(board[nx][ny] == 1) break;
            //머리 넣기
            snake.add(new int[]{nx,ny});
            board[nx][ny] = 1;
            //몇초 일때 방향 하기
            if(dirs.containsKey(time)){
                String direction = dirs.get(time);
                if("L".equals(direction)) dir = (dir + 3) % 4;
                if("D".equals(direction)) dir = (dir + 1) % 4;
            }
            //이동
            x = nx;
            y = ny;

        }


        return time;
    }

}
