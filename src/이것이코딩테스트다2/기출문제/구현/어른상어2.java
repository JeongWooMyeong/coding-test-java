package 이것이코딩테스트다2.기출문제.구현;

import java.io.*;
import java.util.*;

public class 어른상어2 {
    static int N, M, K;
    static int[][] board;   //현재 상어 위치 : 0이면 없음, 수자는 상어번호
    static int[][] smellOwner;  //각 칸 냄새 주인
    static int[][] smellTime;   //각 칸 냄새 남은 시간
    static Shark[] sharks;  //상어 정보 배열

    //상, 하, 좌, 우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    //상어 클래스
    static class Shark{
        int x, y, dir;  //좌표 현재 방향
        boolean alive = true;   //살아 있는지 여부
        int[][] priority = new int[4][4];   //방향 우선 순위 : priority[현재방향][0~3번째 선호]

        Shark(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력 : N(보드 크기), M (상어 수), K (냄새 지속시간)
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        smellOwner = new int[N][N];
        smellTime = new int[N][N];
        sharks = new Shark[M+1];    //상어 번호 1~M;

        //초기 상어 위치 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;  //board에 상어 번호 저장
                if(num > 0){
                    sharks[num] = new Shark(i,j);
                    smellOwner[i][j] = num; //냄새 주인
                    smellTime[i][j] = K;    //냄새 남은시간
                }
            }
        }

        //초기 방향 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            sharks[i].dir = Integer.parseInt(st.nextToken()) - 1;   //0-index;
        }

        //방향 우선순위 입력
        for(int i=1;i<=M;i++){
            for(int d=0;d<4;d++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<4;k++){
                    sharks[i].priority[d][k] = Integer.parseInt(st.nextToken()) -1; // 0-index;
                }
            }
        }
        
        int time = 0;
        
        while(time <= 1000){
            time++;
            move(); // 상어 이동 + 충돌 처리
            updateSmell();  //냄새 감소 + 새 냄새 추가
            //상어 1번만 남앗는지 확인
            if(check()){
                System.out.println(time);
                return;
            }
            
        }
        //1000초 넘어도 상어 1번만 남지 않으면 -1 출력
        System.out.println(-1);

    }

    //상어 이동
    static void move(){
        int[][] nextBoard = new int[N][N];  //이동 후 사애 임시 저장

        for(int i=1;i<=M;i++){
            if(!sharks[i].alive) continue;  //죽은 상어는 스킵
            Shark s = sharks[i];
            int x = s.x, y=s.y, dir= s.dir;
            boolean moved = false;

            //1. 냄새 없는 칸 우선 이동
            for(int k=0;k<4;k++){
                int nd = s.priority[dir][k];    //우선순위 방향
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(smellTime[nx][ny] == 0){
                    //냄새 없으면 이동
                    s.x = nx;
                    s.y = ny;
                    s.dir = nd;
                    moved = true;
                    break;
                }
            }

            //2. 냄새 없는 칸 없으면 자기 냄새 있는 칸으로 이동
            if(!moved){
                for(int k=0;k<4;k++){
                    int nd = s.priority[dir][k];
                    int nx = x + dx[nd];
                    int ny = y + dy[nd];

                    if(nx<0||ny<0||nx>=N||ny>=N) continue;
                    if(smellOwner[nx][ny] == i){
                        s.x = nx;
                        s.y = ny;
                        s.dir = nd;
                        break;
                    }
                }
            }

            int nx = s.x, ny = s.y;

            //충돌 처리
            if(nextBoard[nx][ny] == 0){
                //칸 비어 있으면 바로 배치
                nextBoard[nx][ny] = i;
            }else{
                //이미 상어 있으면 번호 작은것만 살아남음
                if(nextBoard[nx][ny] < i){
                    s.alive = false;    //자기 죽음
                }else{
                    sharks[nextBoard[nx][ny]].alive = false;    //기존 상어 죽음
                    nextBoard[nx][ny] = i;
                }
            }
        }

        board = nextBoard;
    }

    //냄새 업데이트
    static void updateSmell(){
        //기ㅣ존 냄새 감소
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
        
        //상어 새 냄새 추가
        for(int i=1;i<=M;i++){
            if(!sharks[i].alive) continue;
            Shark s = sharks[i];
            smellOwner[s.x][s.y] = i;
            smellTime[s.x][s.y] = K;
        }
    }

    //상어 1번만 남았는지 확인
    static boolean check(){
        for(int i=2;i<=M;i++){
            if(sharks[i].alive) return false;
        }

        return sharks[1].alive;
    }

}
