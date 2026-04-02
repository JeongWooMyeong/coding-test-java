package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 청소년상어2 {
    static int N = 4;
    static Fish[][] map = new Fish[N][N];
    static List<Fish> fishList = new ArrayList<>();
    static Shark shark;
    //대각선 방향까지 고려 (8방향)
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static int maxScore = Integer.MIN_VALUE;

    static class Fish implements Comparable<Fish>{
        int x,y,num,dir;
        boolean alive;
        public Fish(int x, int y, int num, int dir, boolean alive){
            this.x = x;
            this.y = y;
            this.num = num; //물고기 번호
            this.dir = dir; //물고기 방향
            this.alive = alive;  //물고기 살아있는지.
        }
        //물고기 이동 1번~부터 시작해야하므로 정렬
        public int compareTo(Fish other){
            return this.num - other.num;
        }
    }

    static class Shark{
        int x, y, dir, score;

        public Shark(int x, int y, int dir, int score){
            this.x =x;
            this.y = y;
            this.dir = dir;
            this.score = score;   //상어가 물고기 먹은점수

        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. 물고기 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                //방향 처리... 0-index
                int dir = Integer.parseInt(st.nextToken()) -1;
                Fish f = new Fish(i,j,num,dir,true);
                fishList.add(f);
                map[i][j] = f;
            }
        }
        //2.물고기 번호순으로 정렬
        Collections.sort(fishList);

        //3. 상어 초기 위치 확인
        Fish start = map[0][0];
        Shark shark = new Shark(0,0,start.dir, start.num);
        start.alive = false;
        //fishList.get(0).alive = false;

        //fishList = copyList(map);

        //4. dfs 실행
        dfs(map, fishList, shark);

        //5. 최대값 출력
        System.out.print(maxScore);


    }

    static void dfs(Fish[][] map, List<Fish> fishList, Shark shark){
        maxScore = Math.max(maxScore, shark.score);

        //1. 물고기 이동
        moveFishes(map, fishList, shark);

        //2. 상어 이동
        //4x4라 최대 이동이 3까지임
        for(int step=1;step<=3;step++){
            int nx = shark.x + dx[shark.dir]*step;
            int ny = shark.y + dy[shark.dir]*step;

            if(nx < 0 || ny < 0 || nx>=N || ny>=N) continue;
            if(map[nx][ny] == null || !map[nx][ny].alive) continue;

            //상태 복사
            List<Fish> newList = copyFishList(fishList);
            Fish[][] newMap = copyMap(newList);

            //상어 이동
            //상어이동시 복사한 newboard를 써야함
            Fish target = newMap[nx][ny];
            Shark newshark = new Shark(nx, ny, target.dir, shark.score+target.num);
            newList.get(target.num-1).alive = false;    //먹음
            //먹은 물고기 처리
            newMap[nx][ny] = null;


            dfs(newMap, newList, newshark);




        }
    }
    //물고기 이동
    static void moveFishes(Fish[][] map, List<Fish> fishList, Shark shark){
        for(int num=1;num<=16;num++){
            //물고기 번호순대로
            Fish f = fishList.get(num-1);
            //루프 돌기전에 처리
            if(!f.alive) continue;
            //8 방향 이동
            for(int i=0;i<8;i++){
                int ndir = (f.dir+i) % 8;
                int nx = f.x + dx[ndir];
                int ny = f.y + dy[ndir];
                //죽은 물고기면 넘김
                //if(!f.alive) continue;

                //공간의 결계 넘을때
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                //상어 만났을때
                if(shark.x == nx && shark.y == ny) continue;

                //물고기 이동
                Fish target = map[nx][ny];
                map[f.x][f.y] = target;
                if(target != null){
                    target.x = f.x;
                    target.y = f.y;
                }
                map[nx][ny] = f;
                f.x = nx; f.y = ny; f.dir = ndir;
                break;  //이동 후 break 한번 이동

            }
        }
    }
    //여러갈래로 나누어져 있어서 map 복사 (깊은 복사로 해야 독립적인 상태로 됌)
    static Fish[][] copyMap(List<Fish> fishList){
        Fish[][] newMap = new Fish[N][N];
        for(Fish f : fishList){
            if(f.alive){
                newMap[f.x][f.y] = f;
            }
        }
        return newMap;
    }

    static List<Fish> copyFishList(List<Fish> fishList){
        List<Fish> newList = new ArrayList<>();
        for(int i=0;i<16;i++){
            Fish f = fishList.get(i);
            newList.add(new Fish(f.x, f.y, f.num, f.dir, f.alive));
        }
        return newList;
    }

}
