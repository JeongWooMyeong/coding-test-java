package 이것이코딩테스트다.기출문제.BFS;

import java.io.*;
import java.util.*;

class Point{
    int x, y, dist;
    Point(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class 아기상어 {
    static int N;   //공간의 크기
    static int[][] map;
    static int sharkX, sharkY, sharkSize = 2, eatCount = 0;
    static int time = 0;
    static int[] dx = {-1, 0 , 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){ //아기상어 출발위치
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;  //상어 위치는 빈칸 처리
                }
            }
        }

        while(true){
            Point fish = bfs();
            if(fish == null) break; //먹을 수 있는 물고기 없음
            time += fish.dist;
            sharkX = fish.x;
            sharkY = fish.y;
            map[sharkX][sharkY] = 0;
            eatCount++;
            if(eatCount == sharkSize){
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Point bfs(){
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        List<Point> fished = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.dist > minDist) break;

            for(int d=0;d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                int nd = cur.dist + 1;
                //먹을 수 있는 물고기 발견
                if(map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    fished.add(new Point(nx, ny, nd));
                    minDist = nd;   //최단 거리 갱신
                }

                q.add(new Point(nx, ny, nd));
            }
        }

        if(fished.isEmpty()) return null;

        //정렬: 거리 -> x(위쪽) -> y (왼쪽)
        fished.sort((a, b) ->{
            if(a.dist != b.dist) return a.dist - b.dist;
            if(a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        return fished.get(0);

    }
}
