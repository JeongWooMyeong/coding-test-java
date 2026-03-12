package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 톱니바퀴2 {
    static int[][] gears = new int[4][8];
    static int[] offset = new int[4];   //각 톱니바퀴의 12시 방향 인덱스

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //톱니바퀴 입력
        for(int i=0;i<4;i++){
            String line = br.readLine();
            for(int j=0;j<8;j++){
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; // 0-index
            int dir = Integer.parseInt(st.nextToken()); //1 시계 -1 반시계

            rotateWithPropagation(gearNum, dir);
        }

        //점수 계산
        int score = 0;
        for(int i=0;i<4;i++){
            if(gears[i][offset[i]] == 1){
                //12시방향 확인
                score += (1 << i);  //1,2,4,8
            }
        }
        System.out.println(score);
    }

    //회전 전파 처리
    static void rotateWithPropagation(int gearNum, int dir){
        int[] dirs = new int[4];
        dirs[gearNum] = dir;

        //왼쪽 전파
        for(int i=gearNum;i>0;i--){
            if(getTooth(i, 6) != getTooth(i-1, 2)){
                dirs[i-1] = -dirs[i];
            }else break;

        }

        //오른쪽 전파
        for(int i=gearNum;i<3;i++){
            if(getTooth(i, 2) != getTooth(i+1, 6)){
                dirs[i+1] = -dirs[i];
            }else break;
        }

        //실제 회전
        for(int i=0;i<4;i++){
            if(dirs[i] == 1) rotateClockwise(i);
            else if(dirs[i] == -1) rotateCounterClockwise(i);
        }
    }

    //특정 위치 톱니 값 가져오기
    static int getTooth(int idx, int pos){
        return gears[idx][(offset[idx] + pos) % 8];
    }

    //시계 방향 회전
    static void rotateClockwise(int idx){
        offset[idx] = (offset[idx] + 7) % 8;
    }

    //반시계방향 회전
    static void rotateCounterClockwise(int idx){
        offset[idx] = (offset[idx] + 1) % 8;
    }
}
