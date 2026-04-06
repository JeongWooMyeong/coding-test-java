package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 사다리조작 {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = 4;  //3개 넘어가면 -1 출력

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //새로선의 개수
        M = Integer.parseInt(st.nextToken()); //가로선의 개수
        H = Integer.parseInt(st.nextToken());   //세로선마다 가로선을 놓을 수 있는 위치의 개수


        ladder = new boolean[H+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = true;

        }

        dfs(0,1,1);

        System.out.println(answer == 4 ? -1 :answer);

    }

    static void dfs(int count, int x, int y){
        if(count >= answer ) return;
        if(check()){
            answer = count;
            return;
        }
        if(count == 3) return;
        for(int i=x;i<=H;i++){
            for(int j=(i==x ? y : 1); j<N;j++){
                if(!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]){
                    ladder[i][j] = true;
                    dfs(count + 1, i, j+2);
                    ladder[i][j] = false;
                }
            }
        }
    }

    static boolean check(){
        for(int i=1;i<=N;i++){
            int pos = i;
            for(int h=1;h<=H;h++){
                if(ladder[h][pos]) pos++;
                else if(pos > 1 && ladder[h][pos-1]) pos--;
            }
            if(pos != i) return false;
        }
        return true;
    }


}
