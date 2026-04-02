package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 아기상어 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Shark shark;    //아기 상어 정의

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Shark{
        int x, y, size ,eat, time;
        public Shark(int x, int y){
            this.x = x; //아기 상어 x 좌표
            this.y = y; //아기 상어 y 좌표
            this.size = 2;  //아기 상어 크기 2
            this.eat = 0;   //먹은 물고기 수
            this.time = 0;  //시간 저장
        }

    }

    static class Fish implements Comparable<Fish>{
        int x, y, dist;
        public Fish(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;   //물고기 거리 (가까운 물고기 부터 먹어야 하므로)
        }

        public int compareTo(Fish other){
            //이것만으로는 부족
            if(this.dist == other.dist){
                //가장 왼쪽
                if(this.x == other.x){
                    return this.y - other.y;
                }
                //가장 위
                return this.x - other.x;
            }

            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        //맵 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //아기 상어 위치 정의
                if(map[i][j] == 9){
                    shark = new Shark(i,j);
                    //상어 시작위치는 0으로 시작
                    map[i][j] = 0;
                }
            }
        }

        //가까운 물고기부터 타겟 잡아서 진행
        while(true){
            //가까운 물고기 찾기 (조건 만족하는)
            Fish target = bfs();
            //타겟 없으면 종료 (다먹었따는 소리)
            if(target == null) break;
            //먹으면 이자리는 상어의 자리가 되므로 갱신
            shark.x = target.x;
            shark.y = target.y;
            //먹은 개수 증가
            shark.eat++;
            shark.time += target.dist;
            //먹은개수와 상어 크기가 같으면 상어 크기 증가
            if(shark.eat == shark.size){
                shark.size++;
                shark.eat = 0; //먹은 횟수 초기화
            }
            //먹은 자리 0 으로 변경
            map[target.x][target.y] = 0;

        }

        //그리고 shark.time 출력한다.
        System.out.print(shark.time);


    }

    static Fish bfs(){
        Queue<int[]> q = new LinkedList<>();
        List<Fish> fishList = new ArrayList<>();
        visited = new boolean[N][N];
        q.offer(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;


        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny <0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                //지나갈 수 있는 칸 크기 이하까지
                if(map[nx][ny] <= shark.size) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                    if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
                        fishList.add(new Fish(nx, ny, dist + 1));
                    }
                }

            }
        }

        if(fishList.isEmpty()) return null;
        Collections.sort(fishList);

        return fishList.get(0);

    }



}
