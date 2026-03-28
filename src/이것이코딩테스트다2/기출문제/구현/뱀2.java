package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 뱀2 {
    static int N, K, L;
    static Deque<int[]> snake = new ArrayDeque<>();    //뱀 정의
    static Map<Integer, String> moves = new HashMap<>();
    static int[][] board;   //게임 판 정의
    static int time = 0;
    //아 이거 회전하려면 방향 제대로 해야한다.. 상우 하좌 이런식으로
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    //보드
        K = Integer.parseInt(br.readLine());    //사과의 개수

        board = new int[N][N];

        //사과 좌표 입력
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //사과 위치 2로 표시
            board[x-1][y-1] = 2;
        }

        //회전 방향 설정
        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int times = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            moves.put(times, direction);
        }



        //뱀 이동 시뮬레이션
        System.out.println(simulate());


    }

    static int simulate(){
        snake.add(new int[]{0, 0});
        board[0][0] = 1;    //1은 뱀의 위치
        int dir = 1;
        int x = 0;
        int y = 0;

        while(true){
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //일반적인 거라면 continue지만 벽에 부딪쳤을경우 게임 종료
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) return time;
            if(board[nx][ny] == 1) return time;

            //사과
            if(board[nx][ny] == 2){
                snake.addLast(new int[]{nx, ny});
                board[nx][ny] = 1; //뱀 위치 1로 변경
            }else{
                //빈칸일때 꼬리가 위치한 칸 비움
                board[nx][ny] = 1;
                snake.addLast(new int[]{nx, ny});

                int[] tail = snake.pollFirst(); //맨 처음 snak 꺼냄
                board[tail[0]][tail[1]] = 0;    //꼬리 없앰
            }

            x = nx;
            y = ny;

            //만약 map에 들어간 타임이 다가온다면 회전 시행
            if(moves.containsKey(time)){
                String str = moves.get(time);
                if(str.equals("L")) dir = (dir+3) % 4;
                else dir = (dir + 1) % 4;
            }



        }

    }



}
