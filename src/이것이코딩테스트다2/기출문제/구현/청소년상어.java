package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;

public class 청소년상어 {
    static int maxScore = 0;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static class Fish{
        int x, y, dir, num;
        boolean alive;
        public Fish(int x, int y, int dir, int num, boolean alive){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
            this.alive = alive;
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Fish[][] map = new Fish[4][4];
        List<Fish> fishList = new ArrayList<>();

        //입력 : 물고기 번호, 방향
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int num = sc.nextInt();
                int dir = sc.nextInt()-1;
                Fish f = new Fish(i,j,dir,num,true);
                map[i][j] = f;
                fishList.add(f);
            }
        }

        //초기 상어 : 0,0 물고기 먹음
        Fish first = map[0][0];
        Shark shark = new Shark(0,0,first.dir,first.num);
        first.alive = false;
        map[0][0] = null;

        dfs(map, fishList, shark);
        System.out.println(maxScore);

    }

    static void dfs(Fish[][] map, List<Fish> fishList, Shark shark){
        maxScore = Math.max(maxScore, shark.score);

        //1. 물고기 이동
        moveFish(map, fishList, shark);

        //2. 상어 이동( 1~3칸)
        for(int step=1;step<=3;step++){
            int nx = shark.x + dx[shark.dir]*step;
            int ny = shark.y + dy[shark.dir]*step;

            if(nx < 0 || ny < 0 || nx>=4 || ny>=4) break;
            if(map[nx][ny] == null || !map[nx][ny].alive) continue;

            //상태 복사
            Fish[][] newMap = copyMap(map);
            List<Fish> newFishList = copyFishList(fishList);

            //상어 이동
            Fish target = newMap[nx][ny];
            Shark newShark = new Shark(nx,ny,target.dir,shark.score+target.num);
            newFishList.get(target.num-1).alive = false;
            newMap[nx][ny] = null;

            dfs(newMap, newFishList, newShark);
        }
    }

    static void moveFish(Fish[][] map, List<Fish> fishList, Shark shark){
        for(int num=1;num<=16;num++){
            Fish f = fishList.get(num-1);
            if(!f.alive) continue;

            for(int i=0;i<8;i++){
                int ndir = (f.dir+i)%8;
                int nx = f.x + dx[ndir];
                int ny = f.y + dy[ndir];

                if(nx < 0 || ny < 0 || nx >=4 || ny>=4) continue;
                if(shark.x == nx && shark.y == ny) continue;

                //swap
                Fish target = map[nx][ny];
                map[f.x][f.y] = target;
                //이동하는 물고기만 방향 바뀜
                if(target!=null){
                    target.x = f.x;
                    target.y = f.y;
                }
                map[nx][ny] = f;
                f.x = nx; f.y = ny; f.dir = ndir;
                //한번 이동했으면 끝내야함
                break;
            }
        }
    }

    static Fish[][] copyMap(Fish[][] map){
        Fish[][] newMap = new Fish[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(map[i][j]!=null){
                    Fish f = map[i][j];
                    newMap[i][j] = new Fish(f.x,f.y,f.dir,f.num,f.alive);
                }
            }
        }
        return newMap;
    }

    static List<Fish> copyFishList(List<Fish> fishList){
        List<Fish> newList = new ArrayList<>();
        for(Fish f : fishList){
            newList.add(new Fish(f.x,f.y,f.dir,f.num,f.alive));
        }
        return newList;
    }

}
