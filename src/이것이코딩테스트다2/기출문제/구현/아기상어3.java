package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 아기상어3 {
    static int N;
    static int[][] map;
    static List<Fish> fishList; //물고기 리스트 담는
    static Shark shark; //샤크

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Shark{
        int x, y, size, eat, time;
        public Shark(int x, int y){
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eat = 0;
            this.time = 0;
        }
    }

    static class Fish implements Comparable<Fish>{
        int x,y,dist;
        public Fish(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Fish other){
            if(this.dist == other.dist){
                if(this.x == other.x){
                    return this.y - other.y;
                }
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
        //물고기 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 9){
                    shark = new Shark(i,j);
                    map[i][j] = 0;
                }
            }
        }

        //
        while(true){
            Fish target = bfs();
            if(target == null){
                break;
            }
            shark.x = target.x;
            shark.y = target.y;
            shark.eat++;
            shark.time += target.dist;
            if(shark.eat == shark.size){
                shark.size++;
                shark.eat = 0;
            }

            //물고기 먹은 후 map 갱신
            map[target.x][target.y] = 0;
        }

        System.out.print(shark.time);


    }

    static Fish bfs(){
        fishList = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
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

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] <= shark.size) {
                    q.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                    //빈칸이면 안됌
                    if (map[nx][ny] != 0 && map[nx][ny] < shark.size){
                        fishList.add(new Fish(nx, ny, dist+1));
                    }
                }

            }

        }
        if(fishList.isEmpty()) return null;
        Collections.sort(fishList);
        return fishList.get(0);

    }

}
