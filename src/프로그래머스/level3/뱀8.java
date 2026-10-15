package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀8 {

    static int N, K, L;
    static Deque<int[]> snake;
    static Map<Integer, String> dirs;
    static int[][] board;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        //snake = new ArrayDeque<>();
        dirs = new HashMap<>();
        board = new int[N][N];
        //사과 입력 사과 있는곳 2로 표기
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
            String direc = st.nextToken();

            dirs.put(sec, direc);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new ArrayDeque<>();
        snake.add(new int[]{0,0});
        int dir = 1;
        int x = 0;
        int y = 0;
        int time = 0;
        //뱀 위치 1로 표기
        board[x][y] = 1;

        while(true){
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

            if(board[nx][ny] != 2){
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }

            if(board[nx][ny] == 1){
                break;
            }

            snake.addLast(new int[]{nx,ny});
            board[nx][ny] = 1;

            if(dirs.containsKey(time)){
                String d = dirs.get(time);

                if("L".equals(d)){
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
