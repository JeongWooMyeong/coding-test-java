package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀3 {

    static int N, K;
    static int L;
    static Map<Integer, String> map;
    static Queue<int[]> snake;
    static int[][] board;
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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 2;    //사과 위치 0 index
        }

        L = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            map.put(time, dir);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new LinkedList<>();
        snake.add(new int[]{0,0});
        board[0][0] = 1;
        int dir = 1;    //오른쪽 시작

        int time = 0;
        int x = 0;
        int y = 0;
        while(true){

            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //벽 부딪치면 게임종료
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            //사과 만나지 않으면 꼬리 위치한 칸 비워줌
            if(board[nx][ny] != 2){
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }


            //꼬리 제거후 자기 자신 만나면 break;
            if(board[nx][ny] == 1) break;


            if(map.containsKey(time)){
                String ddd = map.get(time);
                if(ddd.equals("L")) dir = (dir + 3) % 4;
                if(ddd.equals("D")) dir = (dir + 1) % 4;
            }

            snake.add(new int[]{nx,ny});
            board[nx][ny] = 1;

            x = nx;
            y = ny;

        }

        return time;
    }

}
