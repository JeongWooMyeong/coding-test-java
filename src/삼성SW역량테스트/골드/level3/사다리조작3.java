package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 사다리조작3 {
    static int N,M,H;
    static boolean[][] ladder;  //사다리 가로선 넣음 유무
    static int answer = 4;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H+1][N+1];
        //M 가로선 기존 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = true;
        }

        //dfs 시행
        dfs(0, 1, 1);

        //결과값 출력
        System.out.print(answer>=4 ? -1 : answer);

    }

    static void dfs(int count, int x, int y){
        if(count >= answer) return;
        //사다리 확인
        if(check()){
            answer = count;
            return;
        }
        if(count == 3) return;

        for(int i=x;i<=H;i++){
            for(int j=(i==x ? y : 1);j<N;j++){
                if(!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]){
                    ladder[i][j] = true;
                    //가로선은 세로선 두번 건너뛰고 설치
                    //이거 왜 i? 같은 높이 (i) 에서 오른쪽 (j 증가) 로 계속 탐색한다/
                    dfs(count + 1, i , j+2);
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
            //h부터 쭉 내려오면서 다르면 무조건 return false
            if(pos != i) return false;
        }
        //fasle 없으면 무조건 true return
        return true;
    }


}
