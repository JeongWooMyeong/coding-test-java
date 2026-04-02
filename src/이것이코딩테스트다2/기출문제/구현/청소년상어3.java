package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 청소년상어3{
    static int N = 4;    //4x4 고정
    static Fish[][] map = new Fish[N][N];
    static List<Fish> fishList = new ArrayList<>();    //물고기 이동 담기 위함
    static int maxScore = Integer.MIN_VALUE;    //물고기 먹은 합계 출력
    //대각선 포함 8가지방향
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static class Fish implements Comparable<Fish>{
        int x, y, num, dir;
        boolean alive;    //물고기 생사여부
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
                //0 index
                int dir = Integer.parseInt(st.nextToken()) - 1;
                Fish f = new Fish(i,j,num,dir,true);
                map[i][j] = f;
                fishList.add(f);
            }
        }

        //번호순으로 물고기 정렬
        Collections.sort(fishList);

        //상어 초기 시작위치 설정
        Fish first = map[0][0];
        Shark shark = new Shark(0, 0, first.dir, first.num);
        first.alive =false;    //초기 물고기는 먹혔으므로 죽음처리

        //dfs 시작
        dfs(map, fishList, shark);

        //maxScore 설정
        System.out.print(maxScore);



    }
    //dfs 이동시 여러갈래로 나뉘고 백트래킹 기법 이용 (째귀)
    static void dfs(Fish[][] map, List<Fish> fishList, Shark shark){
        //최대값 구하기
        maxScore = Math.max(maxScore, shark.score);
        //상어 이동전에 물고기 이동이 먼저 일어나야함
        moveFishes(map, fishList, shark);

        //상어 이동은 4x4 이므로 최대 3까지 이동가능
        for(int step=1;step<=3;step++){
            int nx = shark.x + dx[shark.dir]*step;
            int ny = shark.y + dy[shark.dir]*step;
            //범위 넘어가면 패스
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            //믈고기 없거나 살아 있지 않으면 패스
            if(map[nx][ny] == null || !map[nx][ny].alive) continue;
            //상태복사 (여러갈래 데이터 꼬임 방지)
            List<Fish> newFishList = copyFishList(fishList);
            Fish[][] newMap = copyNewMap(newFishList);

            //이동했을때 물고기 데이터
            Fish f = newMap[nx][ny];
            //새로운 상어 데이터 물고기 먹음으로써 갱신
            Shark newShark = new Shark(nx, ny, f.dir, shark.score+f.num);
            //물고기리스트 alive 죽음처리 (이동시에 필요) - 물고기 번호대로
            newFishList.get(f.num-1).alive =false;
            //물고기 null 처리
            newMap[nx][ny] = null;

            dfs(newMap, newFishList, newShark);

        }

    }

    static void moveFishes(Fish[][] map, List<Fish> fishList, Shark shark){
        //2~16
        for(int num=1;num<=16;num++){
            Fish f = fishList.get(num-1);
            if(!f.alive) continue;
            //8가지 방향 반복
            for(int i=0;i<8;i++){
                int ndir = (f.dir+i) % 8;
                //step을 해야지 읻ㅇ하지..
                int nx = f.x + dx[ndir];
                int ny = f.y + dy[ndir];

                //공간의 결계를 넘을경우
                if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
                //상어를 만날 경우
                if(shark.x == nx && shark.y == ny) continue;
                //swap
                Fish target = map[nx][ny];    //target 지정
                map[f.x][f.y] = target;    //현재 f를 target에 넣음
                if(target != null){    //비어 있찌 않을때
                    target.x = f.x;    //좌표변경
                    target.y = f.y;
                }else{
                    map[f.x][f.y] = null;
                }
                map[nx][ny] = f;    //이동할 fish를 f에 두고
                f.x = nx;    //이동할 좌표로 변경
                f.y = ny;
                f.dir = ndir;
                break;    //한번 이동 후 break

            }

        }
    }

    static Fish[][] copyNewMap(List<Fish> fishList){
        Fish[][] newMap = new Fish[N][N];
        for(int i=0;i<16;i++){
            Fish f = fishList.get(i);
            newMap[f.x][f.y] = f;
        }
        return newMap;
    }

    static List<Fish> copyFishList(List<Fish> fishList){
        List<Fish> newFishList = new ArrayList<>();
        for(int i=0;i<16;i++){
            Fish f = fishList.get(i);
            newFishList.add(new Fish(f.x, f.y, f.num, f.dir, f.alive));
        }
        return newFishList;
    }



}