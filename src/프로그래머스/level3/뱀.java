package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀 {

    static int N;
    static int K;
    static int L;
    static int[][] board;
    static Queue<int[]> snake;
    static Map<Integer, String> moves;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    //전체 개수
        K = Integer.parseInt(br.readLine());    //사과 개수

        board = new int[N][N];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            board[x][y] = 2;    //사과 위치 지정
        }

        L = Integer.parseInt(br.readLine());
        moves = new HashMap<>();

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            moves.put(time, dir);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new LinkedList<>();
        snake.add(new int[]{0,0});
        int dir = 1;    //오른쪽 방향
        int time = 0;

        int x = 0;
        int y = 0;

        while(true){
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) return time;
            if(board[nx][ny] == 1) return time;

            //사과 위치 도달했을때
            if(board[nx][ny] == 2){
                board[nx][ny] = 1;
                snake.add(new int[]{nx,ny});
            }else{
                board[nx][ny] = 1;
                snake.add(new int[]{nx,ny});

                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;

            }

            if(moves.containsKey(time)){
                String direc = moves.get(time);
                if("L".equals(direc)){
                    dir = (dir + 3) % 4;
                }else{
                    dir = (dir + 1) % 4;
                }
            }

            x = nx;
            y = ny;

        }

    }

}
