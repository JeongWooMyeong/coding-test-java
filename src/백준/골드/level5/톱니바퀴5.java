package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 톱니바퀴5 {
    static int n, m;
    static int[][] gear = new int[4][8];    //톱니 8개 톱니바퀴 4개
    static boolean[] visited;  //톱니 방문 여부

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++){
            String line = br.readLine();
            for(int j=0;j<8;j++){
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        while(k-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; //0 index
            int dir = Integer.parseInt(st.nextToken()); //1 시게 -1 반시계
            visited = new boolean[4];
            dfs(num, dir);
        }

        int sum = 0;
        for(int i=0;i<4;i++) if(gear[i][0] == 1) sum += 1 << i;
        System.out.print(sum);


    }

    public static void dfs(int idx, int dir){
        visited[idx] = true;

        //왼쪽 톱니 확인
        if(idx > 0 && !visited[idx -1] && gear[idx][6] != gear[idx-1][2]){
            dfs(idx-1, -dir);   //반시계 방향으로 회전
        }

        //오른쪽 톱니 확인
        if(idx < 3 && !visited[idx + 1] && gear[idx][2] != gear[idx+1][6]){
            dfs(idx+1, -dir);   //반시계 방향으로회전
        }

        rotate(idx, dir);   //실제 회전
    }

    public static void rotate(int idx, int dir){
       if(dir == 1){
           //시계방향
           int temp = gear[idx][7];
           for(int i=7;i>0;i--) gear[idx][i] = gear[idx][i-1];
           gear[idx][0] = temp;
       }else{
           //반시계방향
           int temp = gear[idx][0];
           for(int i=0;i<7;i++) gear[idx][i] = gear[idx][i+1];
           gear[idx][7] = temp;
       }
    }

}
