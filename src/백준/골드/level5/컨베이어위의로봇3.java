package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
이건 1index로 함 -> 0index로 하는게 더 편한듯?
 */

public class 컨베이어위의로봇3 {
    static int N,K;
    static int[] durability;    //컨베이어 내구도
    static boolean[] robot; //로봇의 위치

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2*N+1];
        robot = new boolean[2*N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=2*N;i++){
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while(true){
            //1단계부터 시작
            step++;
            //1. 벨트, 로봇 회전
            rotate();
            //2. 로봇 이동
            moveRobot();
            //3. 로봇 올리기
            upRobot();
            //4. 내구도 0인 칸 계산
            if(countZero() >= K) break;
        }


        System.out.print(step);

    }

    static void rotate(){
        int last = durability[2*N];
        for(int i=2*N;i>1;i--){
            durability[i] = durability[i-1];
        }
        durability[1] = last;

        for(int i=2*N;i>1;i--){
            robot[i] = robot[i-1];
        }
        //1번 로봇을 올리는 자리에는 로봇이 올 ㅜㅅ 없다
        robot[1] = false;
        //N일때 바로 내려야하므로 false
        robot[N] = false;

    }

    //로봇 이동
    static void moveRobot(){
        //로봇은 n가지 n가면 로봇 내리므로
        for(int i=N;i>1;i--){
            //내구도 음수 될 수 있으므로 체크
            if(robot[i-1] && !robot[i] && durability[i] > 0){
                robot[i] = true;
                robot[i-1] = false;
                durability[i]--;
            }
        }
        robot[N] = false;
    }
    //로봇 올리기
    static void upRobot(){
        if(!robot[1] && durability[1] > 0){
            robot[1] = true;
            durability[1]--;
        }
    }
    //내구도 0인칸 찾기
    static int countZero(){
        int count = 0;
        for(int i=1;i<=2 * N;i++){
            if(durability[i] == 0){
                count++;
            }
        }

        return count;
    }

}
