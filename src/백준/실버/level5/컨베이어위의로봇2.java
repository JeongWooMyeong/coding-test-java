package 백준.실버.level5;

import java.util.*;
import java.io.*;

public class 컨베이어위의로봇2
{
    static int N, K;    //개수 및 내구도 0인 칸의 개수
    static int[] durability;    //내구도 배열
    static boolean[] hasRobot;  //로봇 위치

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2 * N];
        hasRobot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++){
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while(true){
            step++;
            //1. 회전
            rotate();
            //2. 로봇 이동
            moveRobot();
            //3. 로봇 올리기
            upRobot();
            //4. 내구도 0인 개수 세기
            if(countZero() >= K) break;
        }

        System.out.print(step);

    }

    //1. 회전
    public static void rotate(){
        int last = durability[2*N-1];
        for(int i=2*N-1;i>0;i--) durability[i] = durability[i-1];
        durability[0] = last;

        for(int j=N-1;j>0;j--){
            hasRobot[j]  = hasRobot[j-1];
        }

        hasRobot[0] = false;
        hasRobot[N-1] = false;
    }

    //2. 로봇 이동
    public static void moveRobot(){
        for(int i=N-1;i>0;i--){
            if(hasRobot[i-1] && !hasRobot[i] && durability[i] > 0){
                hasRobot[i] = true;
                hasRobot[i-1] = false;
                durability[i]--;
            }
        }
        hasRobot[N-1] = false;
    }

    //3.로봇 올리기
    public static void upRobot(){
        if(durability[0] > 0){
            hasRobot[0] = true;
            durability[0]--;
        }
    }

    //4. 내구도 0인 카운트 세기
    public static int countZero(){
        int cnt = 0;
        for(int x : durability){
            if(x == 0) cnt++;
        }

        return cnt;
    }

}
