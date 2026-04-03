package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 어른상어5 {
    static int[][] map;
    static int[][] smellOwner;
    static int[][] smellTime;
    static Shark[] sharks;
    static int N,M,K;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Shark{
        int x,y,dir;
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

        N = Integer.parseInt(st.nextToken());   //맵 크기
        M = Integer.parseInt(st.nextToken());   //상어 수
        K = Integer.parseInt(st.nextToken());   //냄새 지속 시간

        map = new int[N][N];
        smellOwner = new int[N][N];
        smellTime = new int[N][N];
        sharks = new Shark[M+1];

        //맵 크기 입력 및 상어 위치 결ㅈㅇ
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){

                int num = Integer.parseInt(st.nextToken());
                //map도 안넣었네..
                //map[i][j] = num;
                if(num > 0){
                    sharks[num] = new Shark(i,j);
                    //num인데 왜.. i로 했찌?
                    smellOwner[i][j] = num;
                    smellTime[i][j] = K;
                }
            }
        }

        //상어 방향 설정
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            sharks[i].dir = Integer.parseInt(st.nextToken()) - 1;   //0inex 방향
        }

        //상어 방향 우선순위 설정
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            //실수..
            for(int d=0;d<4;d++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<4;k++){
                    s.priority[d][k] = Integer.parseInt(st.nextToken()) -1;//0index 방향
                }
            }
        }

        //상어 시간 구하기
        int time = 0;
        while(time < 1000){
            time++;
            move(); //상어이동
            if(check()){
                //상어가 1만 남앗으면
                System.out.println(time);
                return;
            }
            updateSmell();  //냄새 갱신
        }
        //1000초 이상동안 못찾으면 -1
        System.out.println(-1);

    }
    //상어 이동
    static void move(){
        int[][] nextBoard = new int[N][N];
        int[] nx = new int[M+1];
        int[] ny = new int[M+1];
        int[] ndir = new int[M+1];
        //상어 돌면서
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            int x = s.x;
            int y = s.y;
            int dir = s.dir;
            boolean moved = false;   //냄새 없는 칸 없을때 flag
            //상어 죽어있으면 넘김
            if(!s.alive) continue;
            //냄새 없는 칸 있을때 우선
            for(int j=0;j<4;j++){
                int tdir = s.priority[dir][j];
                int tx = x + dx[tdir];
                int ty = y + dy[tdir];

                if(tx < 0 || ty < 0 || tx >= N || ty>= N) continue;
                //냄새시간이 없을때 냄새가 없음
                if(smellTime[tx][ty] == 0){
                    nx[i] = tx;
                    ny[i] = ty;
                    ndir[i] = tdir;
                    moved = true;
                    break;  //한번 이동 빼먹음
                }


            }

            //빈칸이 없을때 후순위 자기냄새
            if(!moved){
                for(int j=0;j<4;j++){
                    int tdir = s.priority[dir][j];
                    int tx = x + dx[tdir];
                    int ty = y + dy[tdir];

                    if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
                    if(smellOwner[tx][ty] == i){
                        nx[i] = tx;
                        ny[i] = ty;
                        ndir[i] = tdir;
                        break;  //한번 이동 빼먹음
                    }

                }
            }


        }
        //상어 돌면서 충돌 확인
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            //충돌도 생사 확인해야하나?
            if(!s.alive) continue;
            int sx = nx[i];
            int sy = ny[i];
            int sdir = ndir[i];
            //빈칸이면
            if(nextBoard[sx][sy] == 0){
                nextBoard[sx][sy] = i;
            }else{
                if(nextBoard[sx][sy] < i){
                    s.alive = false;    //죽음
                }else{
                    sharks[nextBoard[sx][sy]].alive = false;
                    nextBoard[sx][sy] = i;
                }
            }

        }
        //상어 위치 재갱신
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            //죽은 상어는 x
            if(!s.alive) continue;
            s.x = nx[i];
            s.y = ny[i];
            s.dir = ndir[i];
        }

    }
    //냄새 갱신 (냄새는 여기서)
    static void updateSmell(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //스멜 지속시간이 0보다 크다면
                if(smellTime[i][j] > 0){
                    smellTime[i][j]--;
                    if(smellTime[i][j] == 0){
                        //스멜 owner 0
                        smellOwner[i][j] = 0;
                    }
                }
            }
        }

        //냄새 재갱신
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            //냄새도 갱신할때 죽은 상어는 X
            if(!s.alive) continue;
            smellOwner[s.x][s.y] = i;
            smellTime[s.x][s.y] = K;
        }
    }
    //1인 상어만 남았는지 확인
    static boolean check(){
        for(int i=2;i<=M;i++){
            if(sharks[i].alive){
                return false;
            }
        }

        return sharks[1].alive;
    }

}
