package 삼성SW역량테스트.골드.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
정해져있어서 visited는 필요 없을듯
 */



public class 로봇청소기2 {
    static int N, M;
    static int[][] map;
    static int result = 0;
    static int dir;

    static int[] dx = {-1,0,1,0}; //북동남서
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //로봇 초기 위치 설정
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        //맵 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //청소기가 있는 칸은 빈칸이면 여기도 청소하는 칸으로 치는건가?
        map[x][y] = 0;

        //청소기 이동
        while(true){
            if(map[x][y] == 0){
                map[x][y] = 2;
                result++;
            }

            boolean moved = false;
            //청소되지 않은 빈칸 찾음
            for(int i=0;i<4;i++){
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0){
                    x = nx; y = ny;
                    moved = true;
                    break;
                }

            }

            if(moved) continue;

            //청소되지 않은 빈칸이 없는경우
            int backdir = (dir + 2) % 4;
            int nx = x + dx[backdir];
            int ny = y + dy[backdir];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1){
                x = nx;
                y = ny;
            }else{
                break;
            }


        }

        //청소된 칸 출력
        System.out.print(result);



    }


}
