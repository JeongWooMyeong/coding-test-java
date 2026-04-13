package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
0 index
 */

public class 컨베이어위의로봇4{
    static int N,K;
    static int[] durability;
    static boolean[] hasRobot;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2*N];
        hasRobot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++){
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while(true){
            //1단계부터 시작
            step++;
            //회전
            rotate();
            //로봇이동
            moveRobot();
            //로봇올리기
            upRobot();
            //내구도 0인 개수 세기
            if(countZero() >= K) break;

        }

        System.out.println(step);


    }

    //회전
    static void rotate(){
        int last = durability[2*N-1];
        //컨베이어 벨트 회전 뒤에서 부터
        for(int i=2*N-1;i>0;i--){
            durability[i] = durability[i-1];
        }
        durability[0] = last;
        //로봇 이동
        for(int i=N-1;i>0;i--){
            hasRobot[i] = hasRobot[i-1];
        }

        hasRobot[0] = false;
        hasRobot[N-1] = false;

    }

    //2. 로봇이동
    static void moveRobot(){
        for(int i=N-1;i>0;i--){
            //현재 칸이 비어있고, 이전칸에 로봇이 있을때 그리고 현재 칸 내ㄴ구도 > 0 일때
            if(hasRobot[i-1] && !hasRobot[i] && durability[i] > 0){
                //이전 자리 false
                hasRobot[i-1] = false;
                //온자리 true
                hasRobot[i] = true;
                //내구도 감소
                durability[i]--;
            }
        }
        //내리는 자리는 무조건 false; (바로 내림)
        hasRobot[N-1] = false;
    }

    //3. 로봇올리기
    static void upRobot(){
        if(!hasRobot[0] && durability[0] > 0){
            hasRobot[0] = true;
            durability[0]--;
        }
    }

    //4. 내구도 0인거 찾기
    static int countZero(){
        int count = 0;
        for(int i=0;i<2*N;i++){
            if(durability[i] == 0){
                count++;
            }
        }

        return count;
    }

}