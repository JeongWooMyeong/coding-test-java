package 이것이코딩테스트다.기출문제.DFS;

import java.io.*;
import java.util.*;

class Fish{
    int x, y, dir, num;
    boolean alive;
    Fish(int x, int y, int dir, int num, boolean alive){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.num = num;
        this.alive = alive;
    }
}

public class 청소년상어 {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[] fishes = new Fish[17];
        int[][] map = new int[4][4];

        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;
                fishes[num] = new Fish(i,j,dir,num,true);
                map[i][j] = num;
            }
        }

        //상어 초기 상태
        int firstFish = map[0][0];
        int sharkDir = fishes[firstFish].dir;
        fishes[firstFish].alive =false;
        map[0][0] = -1; // 상어 위치

        dfs(map, fishes, 0, 0, sharkDir, firstFish);

        System.out.println(maxSum);
    }

    static void dfs(int[][] map, Fish[] fishes, int sx, int sy, int sdir, int sum){
        maxSum = Math.max(maxSum, sum);

        //물고기 이동
        moveFish(map, fishes, sx, sy);

        //상어이동
        for(int step=1;step<=3;step++){
            int nx = sx + dx[sdir]*step;
            int ny = sy + dy[sdir]*step;
            if(nx<0||ny<0||nx>=4||ny>=4) break;
            if(map[nx][ny] <= 0) continue;  //빈칸 or 상어

            //상태 복사
            int[][] newMap = new int[4][4];
            for(int i=0;i<4;i++) newMap[i] = map[i].clone();
            Fish[] newFishes = new Fish[17];
            for(int i=1;i<=16;i++){
                Fish f = fishes[i];
                if(f != null) newFishes[i] = new Fish(f.x, f.y, f.dir, f.num, f.alive);
            }

            int eaten = newMap[nx][ny];
            int ndir = newFishes[eaten].dir;
            newFishes[eaten].alive = false;
            newMap[sx][sy] = 0;
            newMap[nx][ny] = -1;

            dfs(newMap, newFishes, nx, ny, ndir, sum+eaten);
        }
    }

    static void moveFish(int[][] map, Fish[] fishes, int sx, int sy){
        for(int i=1;i<=16;i++){
            Fish f = fishes[i];
            if(f==null || !f.alive) continue;
            for(int d=0;d<8;d++){
                int ndir = (f.dir+d) % 8;
                int nx = f.x + dx[ndir];
                int ny = f.y + dy[ndir];
                if(nx<0||ny<0||nx>=4||ny>=4) continue;
                if(nx==sx && ny==sy) continue; //상어 위치

                //swap
                if(map[nx][ny] > 0){
                    int other = map[nx][ny];
                    Fish of = fishes[other];
                    of.x = f.x;
                    of.y = f.y;
                    map[f.x][f.y] = other;
                }else{
                    map[f.x][f.y] = 0;
                }
                map[nx][ny] = f.num;
                f.x=nx;
                f.y=ny;
                f.dir=ndir;
                break;
            }
        }
    }
}
