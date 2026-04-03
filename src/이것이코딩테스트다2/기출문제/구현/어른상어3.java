package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

/*
틀린 소스
 */

public class 어른상어3 {
    static int N,M,K;    //보드 크기, 상어 수, 냄새 지속시간
    static int[][] map; // 상어 위치
    static Shark[] sharks;  //상어들의 모음
    static int[][] SmellOwner;  //냄새 주인
    static int[][] SmellTime;   //냄새 지속시간
    //0,1,2,3으로 하것임 (문제에서는 1,2,3,4)
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Shark{
        int x, y, dir;  //상어 좌표 방향
        boolean alive = true;  //상어 생존 여부
        int[][] priority = new int[4][4];   //우선순위 방향 우선순위방향


        public Shark(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //보드 크기   //보드 크기
        M = Integer.parseInt(st.nextToken());   //상어 수
        K = Integer.parseInt(st.nextToken());   //냄새 지속시간

        map = new int[N][N];
        sharks = new Shark[M+1];    //상어 1부터
        SmellOwner = new int[N][N];
        SmellTime = new int[N][N];

        //맵 크기 및 상어 초기 위치 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num > 0){
                    //위치만
                    sharks[num] = new Shark(i,j);
                    //smell 냄새 지정
                    SmellOwner[i][j] = num;
                    SmellTime[i][j] = K;
                }
            }
        }

        //상어의 방향 정하기
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            sharks[i].dir = Integer.parseInt(st.nextToken()) -1; //0index
        }
        
        //상어 방향 우선순위 정하기
        for(int i=1;i<=M;i++){
            for(int d=0;d<4;d++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    sharks[i].priority[d][k] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        int time = 0;

        while(time<1000){
            time++;
            //상어이동
            move();
            //냄새 갱신
            updateSmell();
            //번호 1만 남았으면
            if(check()){
                System.out.println(time);
                return;
            }

        }

        //100초 넘어도 없으면 -1 출력
        System.out.print(-1);

    }
    //상어 이동
    static void move(){
        int[][] nextBoard = new int[N][N];

        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            int x = s.x;
            int y = s.y;
            int dir = s.dir;
            //냄새 없는 칸 이동했는지.
            boolean moved = false;

            if(!s.alive) continue;

            //1. 일단 우선적으로 냄새 없는 칸 이동
            for(int j=0;j<4;j++){
                int nd = s.priority[dir][j];
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(SmellTime[nx][ny] == 0){
                    s.x = nx;
                    s.y = ny;
                    s.dir = nd;
                    moved = true;
                    break;
                }

            }

            //2. 빈칸 없으면 자기 냄새 있는 칸으로 이동
            if(!moved){
                for(int j=0;j<4;j++){
                    int nd = s.priority[dir][j];
                    int nx = x + dx[nd];
                    int ny = y + dy[nd];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(SmellOwner[nx][ny] == i){
                        s.x = nx;
                        s.y = ny;
                        s.dir = nd;
                        break;
                    }

                }
            }

//            int nx = s.x;
//            int ny = s.y;
//
//            //충돌일때
//            if(nextBoard[nx][ny] == 0){
//                //냄새위치 그냥 넣음
//                nextBoard[nx][ny] = i;
//            }else{
//                if(nextBoard[nx][ny] < i){
//                    s.alive = false;
//                }else{
//                    sharks[nextBoard[nx][ny]].alive = false;
//                    nextBoard[nx][ny] = i;
//                }
//            }

        }
        //map = nextBoard;
    }
    //냄새 갱신
    static void updateSmell(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(SmellTime[i][j] > 0){
                    SmellTime[i][j]--;
                    if(SmellTime[i][j] == 0){
                        SmellOwner[i][j] = 0;
                    }
                }
            }
        }

        //상어 냄새 위치 재갱신
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;
            int x = s.x;
            int y = s.y;
            SmellTime[x][y] = K;
            SmellOwner[x][y] = i;
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
