package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 마법사상어와토네이도5 {

    static int N;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[] sr = {-1,1,-1,1,-2,2,-1,1,0};
    static int[] sc = {1,1,0,0,0,0,-1,-1,-2};
    static int[] percent = {1,1,7,7,2,2,10,10,5};
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado();

        System.out.println(answer);

    }

    static void tornado(){
        int x = N / 2;
        int y = N / 2;

        int len = 1;
        int dir = 0;

        while(true) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int i = 0; i < len; i++) {
                    x += dx[dir];
                    y += dy[dir];

                    seperate(x, y, dir);

                    if(x == 0 && y == 0) return;

                }
                dir = (dir + 1) % 4;
            }
            len++;
        }

    }

    static void seperate(int r, int c, int dir){
        int sand = map[r][c];
        int spreadSum = 0;

        for(int i=0;i<9;i++){
            int nr;
            int nc;

            if(dir == 0){
                nr = r + sr[i];
                nc = c + sc[i];
            }else if(dir == 1){
                nr = r - sc[i];
                nc = c + sr[i];
            }else if(dir == 2){
                nr = r - sr[i];
                nc = c - sc[i];
            }else {
                nr = r + sc[i];
                nc = c - sr[i];
            }

            int amount = sand * percent[i] / 100;

            spreadSum += amount;


            if(nr < 0 || nc < 0 || nr >= N || nc >= N){
                answer += amount;
            }else{
                map[nr][nc] += amount;
            }

        }

        int alpha = sand - spreadSum;

        int ar;
        int ac;

        if(dir == 0){
            ar = r;
            ac = c - 1;
        }else if(dir == 1){
            ar = r+1;
            ac = c;
        }else if(dir == 2){
            ar = r;
            ac = c + 1;
        }else{
            ar = r-1;
            ac = c;
        }

        if(ar < 0 || ac < 0 || ar >= N || ac >= N){
            answer += alpha;
        }else{
            map[ar][ac] += alpha;
        }


    }

}
