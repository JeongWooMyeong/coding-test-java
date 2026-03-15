package 백준.골드.level5;

import java.util.*;
import java.io.*;


public class 톱니바퀴4 {
    static int[][] gear = new int[4][8];
    static boolean[] visited;   //dfs 방문 체크

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //톱니바퀴 초기 상태 입력
        for(int i=0;i<4;i++){
            String s = br.readLine();
            for(int j=0;j<8;j++) gear[i][j] = s.charAt(j) - '0';
        }

        int k = Integer.parseInt(br.readLine());    //회전 명령 개수
        while(k-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; //톱니번호 (0-index)
            int dir = Integer.parseInt(st.nextToken()); //방향 (1 : 시계, -1 : 반시계)

            visited = new boolean[4];   // 매번 새로 방문 배열 초기화
            dfs(num, dir);  //DFS로 연쇄회전 탐색

        }

        //최정 점수 계산 (각 톱니의 12시 방향이 1이면 점수 추가)
        int score = 0;
        for(int i=0;i<4;i++) if(gear[i][0] == 1) score += (1 << i);
        System.out.println(score);
    }

    //DFS 탐색 : 현재 톱니를 회전 시키고, 양옆 톱니가 회전 가능한지 확인
    static void dfs(int idx, int dir){
        visited[idx] = true;    //현재 톱니 방문처리

        //왼쪽 톱니 확인
        if(idx > 0 && !visited[idx - 1] && gear[idx][6] != gear[idx -1][2]){
            dfs(idx - 1, -dir); //맞닿은 극이 다르면 반대 방향으로 회전
        }

        //오른쪽 톱니 확인
        if(idx < 3 && !visited[idx + 1] && gear[idx][2] != gear[idx + 1][6]){
            dfs(idx + 1, -dir); //맞닿은 극이 다르면 반대 방향으로 회전
        }

        //실제 회전 수행
        rotate(idx, dir);

    }

    //톱니 회전 함수
    static void rotate(int idx, int dir){
        if(dir == 1){
            //시계방향 회전
            int t = gear[idx][7];
            for(int i=7;i>0;i--) gear[idx][i] = gear[idx][i-1];
            gear[idx][0] = t;
        } else{
            //반시계 방향 회전
            int t = gear[idx][0];
            for(int i=0;i<7;i++) gear[idx][i] = gear[idx][i+1];
            gear[idx][7] = t;
        }
    }

}
