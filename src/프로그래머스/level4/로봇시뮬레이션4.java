package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 로봇시뮬레이션4 {

    static int A,B,N,M;
    static int[][] map;
    static class Robot{
        int x,y,dir,num;

        public Robot(int x, int y, int dir, int num){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
        }

    }
    static Robot[] robots;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[A+1][B+1];

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        robots = new Robot[N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char direc = st.nextToken().charAt(0);
            int d;

            if(direc == 'N'){
                d = 0;
            }else if(direc == 'E'){
                d = 1;
            }else if(direc == 'S'){
                d = 2;
            }else{
                d = 3;
            }

            robots[i] = new Robot(x,y,d,i);
            map[x][y] = i;
        }


        boolean found = false;
        sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            if(found) continue;

            if(!move(num, cmd, repeat)){
                found = true;
            }

        }

        if(!found) sb.append("OK");

        System.out.println(sb);

    }

    static boolean move(int num, char cmd, int repeat){
        Robot cur = robots[num];

        for(int i=0;i<repeat;i++){
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int rnum = cur.num;

            if(cmd == 'L'){
                dir = (dir + 3) % 4;
            } else if (cmd == 'R'){
                dir = (dir + 1) % 4;
            }else{
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 1 || ny < 1 || nx > A || nx > B){
                    sb.append("Robot " + rnum + " crashes into the wall");
                    return false;
                }

                if(map[nx][ny] != 0){
                    sb.append("Robot " + rnum + " crashes into root " + map[nx][ny]);
                    return false;
                }

                cur.x = nx;
                cur.y = ny;
            }

            cur.dir = dir;

        }

        return true;

    }

}
