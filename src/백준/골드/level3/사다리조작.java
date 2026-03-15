package 백준.골드.level3;

import java.io.*;
import java.util.*;

public class 사다리조작 {
    static int n, m, h;
    static int[][] ladder;  //lader[h][n] = 1 이면 세로선과 n+1번 세로선 연결
    static int answer = 4;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //세로선 개수
        m = Integer.parseInt(st.nextToken());   //가로선 개수
        h = Integer.parseInt(st.nextToken());   //세로선마다 놓을 수 있는 위치 개수

        ladder = new int[h+1][n+1];

        //기존 가로선 입력
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   //세로선 위치 (행)
            int b = Integer.parseInt(st.nextToken());   //세로선 번호 (열)
            ladder[a][b] = 1;   //b와 b+1 연결
        }

        dfs(0, 1, 1);   //가로선 개수, 시작행, 시작열

        System.out.println(answer == 4 ? -1 : answer);
    }

    //DFS로 가로선 추가
    static void dfs(int count, int x, int y){
        if(count >= answer) return; //이미 최소보다 크면 중단
        if(check()){
            answer = count;
            return;
        }
        if(count == 3) return;

        for(int i=x;i<=h;i++){
            for(int j=1;j<n;j++){
                if(ladder[i][j] == 0 && ladder[i][j-1] == 0 && ladder[i][j+1] == 0){
                    ladder[i][j] = 1;   //가로선 추가
                    dfs(count+1, i, j);
                    ladder[i][j] = 0;   //백 트래킹
                }
            }
        }
    }

    //사다리 조건 확인
    static boolean check(){
        for(int i=1;i<n;i++){
            int pos = i;
            for(int k = 1;k<=h;k++){
                if(ladder[k][pos] == 1) pos++;
                else if(pos > 1 && ladder[k][pos-1] == 1) pos--;
            }
            if(pos != i) return false;  //출발점과 도착점이 다르면 실패
        }

        return true;
    }
}
