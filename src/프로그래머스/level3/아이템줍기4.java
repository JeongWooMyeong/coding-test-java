package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기4 {
    static boolean[][] visited;
    static int[][] dist;
    static int[][] map = new int[101][101];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int answer = 0;
        //직사각형 1로 채우기
        for(int[] rec : rectangle)
        {
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];
            for(int i = y1*2; i<=y2*2;i++) {
                for (int j = x1*2;j<=x2*2;j++){
                    map[i][j] = 1;
                }
            }

        }
        //테두리 빼고 안쪽 0으로 바꾸기
        for(int[] rec : rectangle)
        {
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];
            for(int i = y1*2+1; i<=y2*2-1;i++) {
                for (int j = x1*2+1;j<=x2*2-1;j++){
                    map[i][j] = 0;
                }
            }

        }

        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);


        return answer / 2;
    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{startX, startY});
        dist = new int[52][52];
        visited = new boolean[52][52];
        visited[startY][startX] = true;
        dist[startY][startX] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[endY][endX];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101) continue;
                if(visited[ny][nx]) continue;

                if(map[ny][nx] == 1){
                    dist[ny][nx] = dist[y][x] + 1;
                    visited[ny][nx] = true;
                    q.offer(new int[]{nx,ny});
                }

            }



        }
        return -1;

    }

    public static void main(String[] args) throws Exception{
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

}
