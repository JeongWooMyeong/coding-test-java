package 삼성SW역량테스트.골드.level5;

import java.util.*;
import java.io.*;

/*
정해져있어서 visited는 필요 없을듯
 */

/*
내 생각은 bfs로 푸는거였는데 여러가지 경우라서 bfs도
단순 시뮬레이션으로 푸는게 좋음 (bfs는 큐에 담아서 하는 방식이라 어울리지 않음
왜냐하면 로봇은 하나이기 떄문에
 */

public class 로봇청소기 {
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
        bfs(x,y);

        //청소된 칸 출력
        System.out.print(result);



    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        //현재 청소기 위치에 빈칸이면 청소 ? 없어야 할수도 있음
        if(map[x][y] == 0){
            result++;
            map[x][y] = 2;
        }

        boolean valid = false;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            valid = false;

            for(int i=0;i<4;i++) {
                int nx = x1 + dx[dir];
                int ny = y1 + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                //청소 할수 없는 빈칸이 없을 경우
                if (map[nx][ny] != 0) {
                    dir = (dir + 2) % 4;
                    valid = true;
                    break;
                } else {
                    dir = (dir + 3) % 4;
                    break;
                }
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if(valid){
                if(map[nx][ny] == 1){
                    return;
                }else{
                    q.offer(new int[]{nx, ny});
                }
            }else{
                if(map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }
            }


        }

    }

}
