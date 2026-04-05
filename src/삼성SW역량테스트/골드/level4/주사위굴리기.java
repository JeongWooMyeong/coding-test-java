package 삼성SW역량테스트.골드.level4;

import java.util.*;
import java.io.*;

public class 주사위굴리기 {
    static int N,M,x,y,K;
    static int[] dice = new int[6]; //0 윗면, 1 아랫면 2 동 3 서 4 북 5 남
    static int[] dx ={0,0,0,-1,1}; //동서 북남
    static int[] dy ={0,1,-1,0,0};

    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<K;i++){
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //범위 체크
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            roll(dir);
            x = nx; y = ny;

            if(map[x][y] == 0){
                map[x][y] = dice[1];
            }else{
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[0]).append("\n");
        }

        System.out.print(sb);


    }

    static void roll(int dir){
        int[] temp = dice.clone();
        if(dir == 1){
            //동
            dice[0] = temp[3]; dice[1] =temp[2];
            dice[2] = temp[0]; dice[3] = temp[1];
        } else if(dir == 2){
            //서
            dice[0] = temp[2]; dice[1] = temp[3];
            dice[2] = temp[1]; dice[3] = temp[0];
        } else if (dir == 3) {
            //북
            dice[0] = temp[5]; dice[1] = temp[4];
            dice[4] = temp[0]; dice[5] = temp[1];
        } else if (dir == 4){
            //남
            dice[0] = temp[4]; dice[1] = temp[5];
            dice[4] = temp[1]; dice[5] = temp[0];
        }
    }

}
