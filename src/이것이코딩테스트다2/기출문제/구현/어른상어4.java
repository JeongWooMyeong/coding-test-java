package 이것이코딩테스트다2.기출문제.구현;

import java.io.*;
import java.util.*;

public class 어른상어4 {
    static int N, M, K;
    static int[][] map;
    static int[][] smellOwner;  //냄새 주인
    static int[][] smellTime;
    static Shark[] sharks;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Shark{
        int x, y, dir;
        boolean alive = true;
        int[][] priority = new int[4][4];

        public Shark(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//보드 맵
        M = Integer.parseInt(st.nextToken());   //상어수
        K = Integer.parseInt(st.nextToken());   //냄새 지속시간

        map = new int[N][N];
        smellOwner = new int[N][N];
        smellTime = new int[N][N];
        sharks = new Shark[M+1];

        //맵 정보 입력 및 상어 위치 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num > 0){
                   sharks[num] = new Shark(i,j);
                   smellOwner[i][j] = num;
                   smellTime[i][j] = K;
                }
            }
        }

        //상어 방향 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            s.dir = Integer.parseInt(st.nextToken())-1;
        }

        //상어 우선순위 입력
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            for(int d=0;d<4;d++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<4;k++){
                    s.priority[d][k] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        //dfs 실행
        int time = 0;
        while(time < 1000){
            time++;
            move();
            if(check()){
                System.out.print(time);
                return;
            }
            updateSmell();
        }
        System.out.print(-1);
    }
    //상어 이동
    static void move(){
        int[][] nextBoard = new int[N][N];
        int[] nx = new int[M+1];
        int[] ny = new int[M+1];
        int[] ndir = new int[M+1];
        for(int num=1;num<=M;num++){
            Shark s = sharks[num];
            int x = s.x;
            int y = s.y;
            int dir = s.dir;
            boolean moved = false;
            //죽은 상어는 이동하지 않음
            if(!s.alive) continue;

            //냄새가 없는 칸
            for(int i=0;i<4;i++){
                int tdir = s.priority[dir][i];
                int tx = x + dx[tdir];
                int ty = y + dy[tdir];

                if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;

                if(smellTime[tx][ty] == 0){
                    nx[num] = tx;
                    ny[num] = ty;
                    ndir[num] = tdir;
                    moved = true;
                    break;
                }

            }
            if(!moved) {
                //자기 냄새
                for (int i = 0; i < 4; i++) {
                    int tdir = s.priority[dir][i];
                    int tx = x + dx[tdir];
                    int ty = y + dy[tdir];

                    if (tx < 0 || ty < 0 || tx >= N || ty >= N) continue;

                    if (smellOwner[tx][ty] == num) {
                        nx[num] = tx;
                        ny[num] = ty;
                        ndir[num] = tdir;
                        break;
                    }

                }
            }



        }

        //이동 후 충돌 확인
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;
            int sx = nx[i];
            int sy = ny[i];
            int sdir = ndir[i];

            if(nextBoard[sx][sy] == 0){
                nextBoard[sx][sy] = i;
            }else{
                if(nextBoard[sx][sy] < i){
                    s.alive =false;
                }else{
                    sharks[nextBoard[sx][sy]].alive = false;
                    nextBoard[sx][sy] = i;
                 }
            }

        }
        //살아남은 상어들에 대해서 갱신
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;
            s.x = nx[i];
            s.y = ny[i];
            s.dir = ndir[i];

        }
    }

    //냄새 갱신
    static void updateSmell(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(smellTime[i][j] > 0){
                    smellTime[i][j]--;
                    if(smellTime[i][j] == 0){
                        smellOwner[i][j] = 0;
                    }
                }
            }
        }
        //상어 냄새
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;
            int x = s.x;
            int y = s.y;
            smellOwner[x][y] = i;
            smellTime[x][y] = K;

        }


    }

    static boolean check(){
        for(int i=2;i<=M;i++){
            if(sharks[i].alive == true){
                return false;
            }
        }

        return sharks[1].alive;
    }

}
