package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기8 {

    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int answer;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        map = new int[102][102];
        answer = 0;

        for(int[] r : rectangle){
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];

            for(int x=x1*2;x<=x2*2;x++){
                for(int y=y1*2;y<=y2*2;y++){
                    map[x][y] = 1;
                }
            }

        }
        //겉 테두리 빼고 내부 0으로 만들긴
        for(int[] r : rectangle){
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];

            for(int x=x1*2+1;x<=x2*2-1;x++){
                for(int y=y1*2+1;y<=y2*2-1;y++){
                    map[x][y] = 0;
                }
            }

        }

        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return answer / 2;
    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited = new boolean[102][102];
        dist = new int[102][102];
        visited[startX][startY] = true;
        dist[startX][startY] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[x][y];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
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
