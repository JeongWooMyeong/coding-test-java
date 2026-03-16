package 백준.골드.level5;


import java.util.*;

public class 컨베이어위의로봇 {
    static int N, K;    //N : 위쪽 칸 개수 K : 내구도 0인 칸의 개수 조건
    static int[] durability;    //벨트 내구도 (길이 2N)
    static boolean[] hasRobot;  //로봇위치 (위쪽 N캊만 관리)

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        durability = new int[2*N];
        hasRobot = new boolean[N];

        //벨트 내구도 입력
        for(int i=0;i<2*N;i++){
            durability[i] = sc.nextInt();
        }

        int step = 0;   //단계수
        while(true){
            step++;

            //1. 벨트 회전
            rotate();
            //2. 로봇이동
            moveRobots();
            //3. 로봇 올리기
            putRobot();

            //4. 내구도 0인 칸의 개수 확인
            if(countZero() >= K) break;
        }

        System.out.println(step);

    }

    // 1. 벨트 회전
    static void rotate(){
        //내구도 배열 회전 (맨 뒤 값을 앞으로)
        int last = durability[2*N-1];
        for(int i=2*N-1;i>0;i--){
            durability[i] = durability[i-1];
        }
        durability[0] = last;

        //로봇 배열 회전 (뒤에서 앞으로 이동)
        for(int i=N-1;i>0;i--){
            hasRobot[i] = hasRobot[i-1];
        }
        hasRobot[0] = false;    //올리는 위치는 항상 비워둠
        hasRobot[N-1] = false;//내리는 위치는 항상 비워둠
    }

    //2. 로봇 이동
    static void moveRobots(){
        //뒤에서부터 앞으로 확인 (앞 칸이 비어 있고 내구도가 남아 있으면 이동)
        for(int i=N-1;i>0;i--){
            if(hasRobot[i-1] && !hasRobot[i] && durability[i] > 0){
                hasRobot[i] = true; //로봇 이동
                hasRobot[i-1] = false;  //이전 칸 비움
                durability[i]--;    //내구도 감소
            }
        }
        hasRobot[N-1] = false;  //내리는 위치는 항상 비워둠
    }

    //3. 로봇 올리기
    static void putRobot(){
        //올리는 위치 (0번칸)에 내구도가 남아 있으면 로봇 올림
        if(durability[0] > 0){
            hasRobot[0] = true;
            durability[0]--;

        }
    }

    //4. 내구도 0인 칸 개수 세기
    static int countZero(){
        int cnt = 0;
        for(int d : durability){
            if(d == 0) cnt++;
        }
        return cnt;
    }

}
