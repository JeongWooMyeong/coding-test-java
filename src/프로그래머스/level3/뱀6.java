package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀6 {

    static int N, K;
    static int[][] board;
    static Queue<int[]> snake;
    static Map<Integer, String> map;
    static int L;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        board = new int[N][N];
        //사과 위치
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            board[a][b] = 2;

        }

        L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            map.put(sec,dir);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new LinkedList<>();
        //snake.add(new int[]{0,0,0,1});
        snake.add(new int[]{0,0});
        int dir = 1;    //오른쪽 시작
        int time = 0;

        int x = 0;
        int y = 0;

        board[x][y] = 1;    //뱀위 의치

        while(true){
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //1. 벽 만났을때
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            //2. 사과 아닐때 꼬리 제거
            if(board[nx][ny] != 2){
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }
            //3. 자기 자신과 만났을때
            if(board[nx][ny] == 1) break;
            //4. 몸통 넣기
            snake.add(new int[]{nx,ny});
            board[nx][ny] = 1;
            //5. 시간비교 해서 dir 변경
            if(map.containsKey(time)){
                String d = map.get(time);
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
