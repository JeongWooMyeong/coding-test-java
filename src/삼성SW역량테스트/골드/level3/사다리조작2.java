package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 사다리조작2 {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = 4;  //4이상이면 -1 출력

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        //사다리 정의 (H 가로선, N 세로선)
        ladder = new boolean[H+1][N+1];

        //M은 기존에 있는 가로선
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //가로선을 놔둠 true (잇냐 없냐)
            ladder[a][b] = true;

        }
        //count 시작 x,y 위치
        dfs(0,1,1);
        //결과값 도출
        System.out.print(answer);

    }
    //사다리 선택
    static void dfs(int count, int x, int y){
        if(answer >= count) return;
        if(check()){
            answer = count;
            return;
        }
        //x일때는 y부터 하면 됌 (중복 방지)
        for(int i=x;i<=H;i++){
            for(int j=(i==x ? y : 1);j<=N;j++){
                if(!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]) {
                    ladder[i][j] = true;
                    //i,j에 설치하면 두개 건너뛰어야함
                    dfs(count + 1, i + 1, j + 2);
                    ladder[i][j] = false;
                }
            }
        }

    }

    //사다리 검증
    static boolean check(){
        for(int i=1;i<=N;i++){
            int pos = i;
            for(int j=1;j<=H;j++){
                if(ladder[j][pos]) pos++;
                else if(pos > 1 && ladder[j][pos-1]) pos--;
            }
            if(pos != i) return false;
        }
        return true;
    }

}
