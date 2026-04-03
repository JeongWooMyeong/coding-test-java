package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 청소년상어4 {
    static int N = 4;
    static Fish[][] map = new Fish[N][N];   //물고기 담을 배열
    static List<Fish> fishList = new ArrayList<>();//물고기 이동 리스트 배열과 동기화
    static Shark shark; //상어
    static int maxScore = Integer.MIN_VALUE;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static class Fish implements Comparable<Fish>{
        int x, y, num, dir;
        boolean alive;  //살았는지 죽었는지

        public Fish(int x, int y, int num, int dir, boolean alive){
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }
        //번호 오름차순 (물고기 이동 위해)
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

        //물고기 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1; //방향 0iindex 때문에

                Fish f = new Fish(i,j,num,dir,true);
                map[i][j] = f;
                fishList.add(f);
            }
        }
        //번호 순 정렬
        Collections.sort(fishList);

        //상어 초기 위치 설정
        Fish first = map[0][0];
        shark = new Shark(first.x, first.y, first.dir, first.num);
        fishList.get(first.num-1).alive = false;
        map[0][0] = null;
        //dfs 실행
        dfs(map, fishList, shark);

        //max score 출력
        System.out.print(maxScore);

    }

    static void dfs(Fish[][] map, List<Fish> fishList, Shark shark){
        maxScore = Math.max(maxScore, shark.score);

        //물고기 이동 우선 진행
        moveFishes(map, fishList, shark);

        //상어 이동 (여러칸 이동 가능) - 문제에서는 4x4 최대 3칸 이동
        for(int step=1;step<=3;step++){
            int nx = shark.x + dx[shark.dir] * step;
            int ny = shark.y + dy[shark.dir] * step;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(map[nx][ny] == null || !map[nx][ny].alive) continue;

            List<Fish> newfishList = copyFishList(fishList);
            //여기서 새로운 newfishList 사용해야함
            Fish[][] newmap = copyNewMap(newfishList);

            Fish target = newmap[nx][ny];
            Shark newShark = new Shark(target.x, target.y, target.dir, shark.score+target.num);
            newfishList.get(target.num-1).alive = false;
            // ⭐⭐⭐ 먹은 자리 비우기 (이거 핵심)
            newmap[nx][ny] = null;

            dfs(newmap, newfishList, newShark);


        }


    }

    static void moveFishes(Fish[][] map, List<Fish> fishList, Shark shark){
        //16마리 물고기
        for(int num=1;num<=16;num++){
            //물고기 꺼냄
            Fish f = fishList.get(num-1);
            if(!f.alive) continue;
            for(int i=0;i<8;i++){
                int ndir = (f.dir + i) % 8;
                int nx = f.x + dx[ndir];
                int ny = f.y + dy[ndir];

                if(nx < 0 || ny < 0 || ny >= N || nx >= N) continue;
                //상어 만나거나
                if(shark.x == nx && shark.y == ny) continue;
                //swap 처리
                Fish target = map[nx][ny];
                //map[f.x][f.y] = target;
                if(target != null){
                    map[f.x][f.y] = target;
                    target.x = f.x;
                    target.y = f.y;
                }else{
                    map[f.x][f.y] = null;
                }
                map[nx][ny] = f;
                f.x = nx;
                f.y = ny;
                f.dir = ndir;
                break; //한번 이동
            }
        }
    }

    static List<Fish> copyFishList(List<Fish> fishList){
        List<Fish> newFishList = new ArrayList<>();
        for(int i=0;i<=15;i++){
            Fish f = fishList.get(i);
            newFishList.add(new Fish(f.x, f.y, f.num, f.dir, f.alive));
        }

        Collections.sort(newFishList);

        return newFishList;
    }

    static Fish[][] copyNewMap(List<Fish> fishList){
        Fish[][] newmap = new Fish[N][N];
        for(int i=0;i<=15;i++){
            Fish f = fishList.get(i);
            if(f.alive) {
                newmap[f.x][f.y] = f;
            }
        }
        return newmap;
    }

}
