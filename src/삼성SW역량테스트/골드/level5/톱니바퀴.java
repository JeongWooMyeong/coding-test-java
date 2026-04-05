package 삼성SW역량테스트.골드.level5;

import java.util.*;
import java.io.*;

public class 톱니바퀴 {
    static int[][] gear = new int[4][8];
    static int K;
    //여기도 실수.. 회전할때마다 초기화 해줘야하는건데..
    //static boolean[] visited = new boolean[4];
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0;j<8;j++){
                //초보적인 실수 int인데... char으로 넣네..
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        while(K-- > 0){
            visited = new boolean[4];
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            //1 시계방향 -1 반시계방향
            dfs(num-1, dir);
        }

        int sum = 0;
        for(int i=0;i<4;i++) if(gear[i][0] == 1) sum += 1 << i;
        System.out.println(sum);
    }

    static void dfs(int idx, int dir){
        //현재 톱니 방문 처리
        visited[idx] = true;
        //idx가 왼쪽 끝이 아니면 왼쪽 톱니 비교 가능
        //비교하는 톱니가 극이 다르면 비교하는 톱니는 반대방향으로 회전하게 됨
        if(idx > 0 && !visited[idx-1] && gear[idx][6] != gear[idx-1][2]){
            dfs(idx - 1, -dir);
        }
        //오른쪽 톱니 비교 맨 오른쪽에 있어서는 안됌
        if(idx < 3 && !visited[idx+1] && gear[idx][2] != gear[idx+1][6]){
            dfs(idx + 1, -dir);
        }

        //다 맞추고 실제 회전
        rotate(idx, dir);

    }

    static void rotate(int idx, int dir){
        //시계방향
        if(dir == 1){
            int temp = gear[idx][7];
            for(int i=7;i>0;i--){
                gear[idx][i] = gear[idx][i-1];
            }
            gear[idx][0] = temp;
        }else{
            int temp = gear[idx][0];
            for(int i=0;i<7;i++){
                gear[idx][i] = gear[idx][i+1];
            }
            //맞네 0이아닌 7이여야 반시계지..
            gear[idx][7] = temp;
        }
    }

}
