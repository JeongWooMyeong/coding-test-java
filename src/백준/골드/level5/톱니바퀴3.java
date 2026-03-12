package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 톱니바퀴3 {
    static int[][] gears = new int[4][8];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //톱니 바퀴 입력
        for(int i=0;i<4;i++){
            String line = br.readLine();
            for(int j=0;j<8;j++){
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; //0
            int dir = Integer.parseInt(st.nextToken()); //1 시계 -1 반시계

            rotateWithPropagation(gearNum, dir);
        }

        //점수 계산
        int score = 0;
        for(int i=0;i<4;i++){
            if(gears[i][0] == 1){
                score += (1 << i);
            }
        }

        System.out.println(score);
    }

    static void rotateWithPropagation(int gearNum, int dir){
        int[] dirs = new int[4];
        dirs[gearNum] = dir;

        //왼쪽 전파
        for(int i=gearNum;i>0;i--){
            if(gears[i][6] != gears[i-1][2]){
                dirs[i-1] = -dirs[i];
            }else break;
        }

        //오른쪽 전파
        for(int i=gearNum;i<3;i++){
            if(gears[i][2] != gears[i+1][6]){
                dirs[i+1] = -dirs[i];
            }else break;
        }

        //실제 회전
        for(int i=0;i<4;i++){
            if(dirs[i] == 1) rotateClockwise(gears[i]);
            else if (dirs[i] == -1) rotateCounterClockwise(gears[i]);
        }

    }

    static void rotateClockwise(int[] gear){
        int last = gear[7];
        for(int i=7;i>0;i--) gear[i] = gear[i-1];
        gear[0] = last;
    }

    static void rotateCounterClockwise(int[] gear){
        int first = gear[0];
        for(int i=0;i<7;i++) gear[i] = gear[i+1];
        gear[7] = first;
    }

}
