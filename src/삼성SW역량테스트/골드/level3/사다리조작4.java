package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 사다리조작4 {
    static int N,M,H;
    static boolean[][] ladder;
    static int answer = 4;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = true;
        }

        dfs(0, 1, 1);

        System.out.print(answer>=4 ? -1 : answer);


    }

    static void dfs(int count, int x, int y){
        if(count >= answer) return;
        if(check()){
            answer = count;
            return;
        }

        for(int i=x;i<=H;i++){
            for(int j=(i==x ? y : 1);j<N;j++){
                if(!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]){
                    ladder[i][j] = true;
                    dfs(count + 1, i, j+2);
                    //백트래킹
                    ladder[i][j] = false;
                }
            }
        }

    }

    static boolean check(){
        for(int i=1;i<=N;i++){
            int pos = i;
            for(int h=1;h<=H;h++){
                //있으면 세로 ++
                if(ladder[h][pos]) pos++;
                //ex 2->1 로가는 경우 --
                else if(pos > 1 && ladder[h][pos-1]) pos--;

            }
            if(pos != i) return false;
        }
        return true;
    }

}
