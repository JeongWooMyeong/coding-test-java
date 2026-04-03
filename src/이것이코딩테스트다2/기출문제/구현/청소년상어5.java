package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 청소년상어5 {
    static int N = 4;
    static Fish[][] map = new Fish[N][N];
    static List<Fish> fishList = new ArrayList<>();
    static Shark shark;
    static int maxScore = Integer.MIN_VALUE;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static class Fish implements Comparable<Fish>{
        int x, y, num, dir;
        boolean alive;

        public Fish(int x, int y, int num, int dir, boolean alive){
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }

        public int compareTo(Fish other){
            return this.num - other.num;
        }

    }

    static class Shark{
        int x, y, dir, score;
        public Shark(int x, int y, int dir, int score){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;   //아 이거땜누에 한참 0index
                Fish f = new Fish(i, j, num, dir, true);
                map[i][j] = f;
                fishList.add(f);

            }
        }

        Collections.sort(fishList);

        //상어 초기 위치 넣기
        Fish first = map[0][0];
        shark = new Shark(0,0,first.dir, first.num);
        fishList.get(first.num-1).alive = false;
        //map 촉화 (빼먹음)
        map[0][0] = null;

        //dfs 실행
        dfs(map, fishList, shark);

        //최종 결과 출력
        System.out.print(maxScore);

    }

    static void dfs(Fish[][] map, List<Fish> fishList, Shark shark){
        maxScore = Math.max(maxScore, shark.score);
        //물고기 이동
        movefishes(map, fishList, shark);
        //상어 이동
        for(int step=1;step<=3;step++){
            int nx = shark.x + dx[shark.dir]*step;
            int ny = shark.y + dy[shark.dir]*step;

            if(nx < 0 || ny < 0 || nx>=N || ny>=N) continue;
            if(map[nx][ny] == null || !map[nx][ny].alive) continue;

            List<Fish> newFishList = copyFishList(fishList);
            Fish[][] newMap = copyNewMap(newFishList);

            Fish target = newMap[nx][ny];
            Shark newShark = new Shark(nx, ny, target.dir, shark.score+target.num);
            //먹으면 먹은 자리 초기화 (빼먹음)
            newFishList.get(target.num-1).alive = false;
            newMap[target.x][target.y] = null;

            dfs(newMap, newFishList, newShark);

        }

    }

    static void movefishes(Fish[][] map, List<Fish> fishList, Shark shark){
        for(int num=1;num<=16;num++){
            Fish f = fishList.get(num-1);
            int x = f.x;
            int y = f.y;
            int dir = f.dir;

            if(!f.alive) continue;

            for(int i=0;i<8;i++){
                int ndir = (f.dir + i) % 8;
                int nx = x + dx[ndir];
                int ny = y + dy[ndir];

                if(nx < 0 || ny <0 || nx >= N || ny >= N) continue;
                if(nx == shark.x && ny == shark.y) continue;

                Fish target = map[nx][ny];
//                if(target != null){
//                    map[f.x][f.y] = target;
//                    target.x = f.x;
//                    target.y = f.y;
//                }else{
//                    map[f.x][f.y] = null;
//                }
//                map[nx][ny] = f;
//                f.x = nx;
//                f.y = ny;
//                f.dir = ndir;
                if(target != null){
                    int tx = target.x, ty = target.y;
                    target.x = f.x; target.y = f.y;
                    f.x = tx; f.y = ty;

                    map[target.x][target.y] = target;
                    map[f.x][f.y] = f;
                }else{
                    map[f.x][f.y] = null;
                    map[nx][ny] = f;
                    f.x = nx; f.y = ny;
                }
                f.dir = ndir;
                break;  //한번 이동후 brek
            }

        }
    }

    static List<Fish> copyFishList(List<Fish> fishList){
        List<Fish> newFishList = new ArrayList<>();
        for(int i=0;i<16;i++){
            Fish f = fishList.get(i);
            newFishList.add(new Fish(f.x, f.y, f.num, f.dir, f.alive));
        }

        //정렬해줘야함
        Collections.sort(newFishList);

        return newFishList;
    }

    static Fish[][] copyNewMap(List<Fish> newFishList){
        Fish[][] Newmap = new Fish[N][N];
        for(int i=0;i<16;i++){
            Fish f = newFishList.get(i);
            if(f.alive){
                Newmap[f.x][f.y] = f;
            }
        }

        return Newmap;
    }

}
