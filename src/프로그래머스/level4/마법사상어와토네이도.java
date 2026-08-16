package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 마법사상어와토네이도 {

    static int N;
    static int[][] map;
    static int answer;

    //토네이도 이도오방향
    //0 : 왼쪽 1 : 아래 2 :오른쪽 3: 위
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};

    /*
    * 토네이도가 왼쪽으로 이동할 때의 모래 분배 위치
    * sr[i], sc[i] = 현재 칸 기준 상대 좌표
    * percent[i] = 해당 우치로 보낼 모래 비율
    * */
    static int[] sr = {
            -1,
            1,
            -1,
            1,
            -2,
            2,
            0,
            -1,
            1
    };

    static int[] sc = {
            1,
            1,
            0,
            0,
            0,
            0,
            -2,
            -1,
            -1
    };

    static int[] percent = {
            1,
            1,
            7,
            7,
            2,
            2,
            5,
            10,
            10
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int r=0;r<N;r++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int c=0;c<N;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        tornado();

        System.out.println(answer);
    }

    //토네이도 이동
    static void tornado(){
        //가운데에서 시작
        int r = N / 2;
        int c = N / 2;

        //처음 방향은 왼쪽
        int dir = 0;

        //이동 거리
        int len = 1;

        while(true){
            //같은 길이 두번 이동
            for(int repeat = 0;repeat<2;repeat++){
                for(int i=0;i<len;i++){
                    r += dr[dir];
                    c += dc[dir];

                    spread(r, c, dir);

                    //0,0도착하면 Rmx
                    if(r == 0 && c == 0){
                        return;
                    }
                }

                dir = (dir + 1) % 4;

            }

            len++;
        }

    }

    static void spread(int r, int c, int dir){
        int sand = map[r][c];

        //현재 칸의 모래를 모두 처리할 것이므로
        //마지막에 0으로 만들어준다.
        int spreadSum = 0;

        for(int i=0;i<9;i++){
            int nr;
            int nc;

            /*
            sr,sc는 왼쪽 방향 기준 좌표
            방향에 따라 좌표를 회전시킨다.
             */

            if(dir == 0){
                nr = r + sr[i];
                nc = c + sc[i];
            }else if(dir == 1){
                nr = r - sc[i];
                nc = c + sr[i];
            }else if(dir == 2){
                nr = r - sr[i];
                nc = c - sc[i];
            }else{
                nr = r + sc[i];
                nc = c - sr[i];
            }

            int amount = sand * percent[i] / 100;

            spreadSum += amount;

            if(nr < 0 || nr >= N || nc < 0 || nc >= N){
                answer += amount;
            }else{
                map[nr][nc] += amount;
            }


        }

        /*
        a계산
        100% 중에서 위에서 분배한 비율을 제외한 나머지
         */
        int alpha = sand - spreadSum;

        int ar;
        int ac;

        //a위치도 방향에 따라 달라짐
        if(dir == 0){
            //왼쪽
            ar = r;
            ac = c - 1;
        }else if (dir == 1){
            //아래
            ar = r + 1;
            ac = c;
        }else if(dir == 2){
            //오른쪽
            ar = r;
            ac = c + 1;
        }else{
            //위
            ar = r-1;
            ac = c;
        }

        if(ar < 0 || ar >= N || ac < 0 || ac >= N){
            answer += alpha;
        }else{
            map[ar][ac] += alpha;
        }

        //현재 칸의 모래는 전부 뿌렸으므로 0
        map[r][c] = 0;

    }


}
