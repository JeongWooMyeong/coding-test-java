package 이것이코딩테스트다2.기출문제.구현;

import java.io.*;
import java.util.*;

/*
불완전 - 안되는 소스 같음
 */

public class 어른상어 {
    static int N, M, K;
    static int[][] smellOwner, smellTime;
    static Shark[] sharks;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Shark{
        int x, y, dir;
        boolean alive = true;
        int[][] priority;   //방향 우선순위

        Shark(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.priority = new int[4][4];
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        smellOwner = new int[N][N];
        smellTime = new int[N][N];
        sharks = new Shark[M+1];

        //초기 상어 위치
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num > 0){
                    sharks[num] = new Shark(i,j,0);
                    smellOwner[i][j] = num;
                    smellTime[i][j] = K;
                }
            }
        }

        //초기 방향
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            sharks[i].dir = Integer.parseInt(st.nextToken()) -1;
        }

        //우선 순위 입력
        for(int i=1;i<=M;i++){
            for(int d=0;d<4;d++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<4;k++){
                    sharks[i].priority[d][k] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        int time = 0;
        while(time <= 1000){
            moveSharks();     // 상어 이동 및 충돌 처리
            updateSmell();    // 냄새 감소 + 새 냄새 찍기
            time++;
            if(checkOnlyOne()){
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);

    }

    static void moveSharks(){
        int[][] newOwner = new int[N][N];
        int[][] newTime = new int[N][N];

        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;

            boolean moved=false;
            //1. 냄새 없는 칸 우선
            for(int k=0;k<4;k++){
                int ndir = s.priority[s.dir][k];
                int nx  = s.x + dx[ndir];
                int ny = s.y + dy[ndir];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(smellTime[nx][ny] == 0){
                    s.x =nx;
                    s.y = ny;
                    s.dir = ndir;
                    moved = true;
                    break;
                }
            }

            //2.자기 냄새 칸
            if(!moved){
                for(int k=0;k<4;k++){
                    int ndir = s.priority[s.dir][k];
                    int nx = s.x  + dx[ndir];
                    int ny = s.y + dy[ndir];
                    if(nx<0||ny<0||nx>=N||ny>=N) continue;
                    if(smellOwner[nx][ny] == i){
                        s.x=nx; s.y=ny; s.dir= ndir;
                        break;
                    }
                }
            }
        }

        // 충돌 처리: 같은 칸에 여러 상어가 있으면 작은 번호만 생존
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;
            for(int j=i+1;j<=M;j++){
                Shark t = sharks[j];
                if(!t.alive) continue;
                if(s.x == t.x && s.y == t.y){
                    // 번호 작은 상어만 생존
                    if(i < j) t.alive = false;
                    else s.alive = false;
                }
            }
        }
    }

    static void updateSmell(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(smellTime[i][j]>0){
                    smellTime[i][j]--;
                    if(smellTime[i][j]== 0){
                        smellOwner[i][j] = 0;
                    }
                }
            }
        }
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            if(!s.alive) continue;
            smellOwner[s.x][s.y] = i;
            smellTime[s.x][s.y] = K;
        }
    }

    static boolean checkOnlyOne(){
        for(int i=2;i<=M;i++){
            if(sharks[i].alive) return false;
        }
        return sharks[1].alive;
    }

}
