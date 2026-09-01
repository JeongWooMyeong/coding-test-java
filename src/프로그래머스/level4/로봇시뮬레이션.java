package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 로봇시뮬레이션 {

    static int A,B,N,M;
    static Robot[] robot;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Robot{
        int num;
        int x,y;
        int dir;

        public Robot(int num, int x, int y, int dir){
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[A+1][B+1];
        robot = new Robot[N+1];
        sb = new StringBuilder();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            int d;

            if(dir == 'N'){
                d = 0;
            }else if(dir == 'E'){
                d = 1;
            }else if(dir == 'S'){
                d = 2;
            }else{
                d = 3;
            }

            robot[i+1] = new Robot(i+1,x,y,d);
            map[x][y] = i+1;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            if(!move(num, dir, repeat)){
                break;
            }
        }

        System.out.println(sb);

    }

    static boolean move(int num, char dir, int repeat){
        Robot rb = robot[num];
        int x = rb.x;
        int y = rb.y;
        int d = rb.dir;
        int num1 = rb.num;


        for(int i=0;i<repeat;i++){

            if(dir == 'L'){
                d = (d + 3) % 4;
            }else if(dir == 'R'){
                d = (d + 1) % 4;
            }else if(dir == 'F') {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 1 || ny < 1 || nx > A || ny > B) {
                    sb.append("Robot " + num1 + " crashes into the wall");
                    return false;
                }

                if (map[nx][ny] != 0) {
                    sb.append("Robot " + num1 + " crashes into robot " + map[nx][ny]);
                    return false;
                }

                map[x][y] = 0;
                map[nx][ny] = num1;

                x = nx;
                y = ny;
            }

        }

        rb.x = x;
        rb.y = y;
        rb.dir = d;

        return true;
    }

}
