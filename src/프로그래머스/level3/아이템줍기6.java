package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기6 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int answer = 0;
        int n = rectangle.length;
        int m = rectangle[0].length;

        map = new int[102][102];
        visited = new boolean[102][102];
        dist = new int[102][102];
        //1. 각 직사각형 내부 1로 채우기
        for(int[] rec : rectangle){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            for(int i=x1*2;i<=x2*2;i++){
                for(int j=y1*2;j<=y2*2;j++){
                    map[j][i] = 1;
                }
            }

        }

        //2. 각 직사각형 테두리만 남기고 0처리
        for(int[] rec : rectangle){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            for(int i=x1*2+1;i<=x2*2-1;i++){
                for(int j=y1*2+1;j<=y2*2-1;j++){
                    map[j][i] = 0;
                }
            }

        }

        //3.각 캐릭터 이동
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);


        return answer/2;
    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startY][startX] = true;
        dist[startY][startX] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[y][x];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if(visited[ny][nx]) continue;

                if(map[ny][nx] == 1){
                    q.offer(new int[]{nx,ny});
                    dist[ny][nx] = dist[y][x] + 1;
                    visited[ny][nx] = true;
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
