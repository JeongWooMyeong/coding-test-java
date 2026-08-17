package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 마법사상어와토네이도3 {

    static int N;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int[] sr = {-1,1,-2,2,-1,1,0,-1,1};
    static int[] sc = {1,1,0,0,0,0,-2,-1,-1};
    static int[] percent = {1,1,2,2,7,7,5,10,10};
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
        int r = N / 2;
        int c = N / 2;

        int len = 1;
        int dir = 0;

        while(true){
            for(int repeat =0;repeat<2;repeat++){
                for(int i=0;i<len;i++){

                    r += dr[dir];
                    c += dc[dir];

                    if(r == 0 &&  c == 0) return;

                    seperate(r,c,dir);

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
            }else{
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

        map[r][c] = 0;

    }

}
