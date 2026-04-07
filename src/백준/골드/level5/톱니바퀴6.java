package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 톱니바퀴6 {
    static int[][] gear = new int[4][8];
    static int K;
    static boolean[] visited;
    //0 N 1 S극
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<4;i++){
            String line = br.readLine();
            for(int j=0;j<8;j++){
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            visited = new boolean[4];
            dfs(num-1, dir);
        }

        int result = 0;
        for(int i=0;i<4;i++) {
            if(gear[i][0] == 1) result += 1 << i;
        }

        System.out.println(result);
    }

    static void dfs(int idx, int dir){
        visited[idx] = true;
        //중복 처리가 안되어 있어서 메모리 초과 오류남
        if(idx > 0 && !visited[idx-1] && gear[idx][6] != gear[idx-1][2]){
            dfs(idx -1, -dir);
        }

        if(idx < 3 && !visited[idx+1] && gear[idx][2] != gear[idx+1][6]){
            dfs(idx +1, -dir);
        }

        rotate(idx,dir);

    }

    static void rotate(int idx, int dir){
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
            gear[idx][7] = temp;
        }
    }

}
