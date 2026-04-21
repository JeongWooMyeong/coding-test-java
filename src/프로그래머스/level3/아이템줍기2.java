package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기2 {
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[][] dist = new int[101][101];

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int answer = 0;

        //전체 + 내부 채우기
        for(int[] rec : rectangle){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            for(int y=y1*2;y<=y2*2;y++){
                for(int x=x1*2;x<=x2*2;x++){
                    //좌표 배열은 반대
                    map[y][x] = 1;
                }
            }
        }

        //내부 0으로 채우기
        for(int[] rec : rectangle){
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];
            //내부 0으로 채우기 (다 처리하고 하는게 맞네..)
            for(int y=y1*2+1;y<y2*2;y++){
                for(int x=x1*2+1;x<x2*2;x++){
                    map[y][x] = 0;
                }
            }
        }

        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);



        return answer / 2;
    }

    static int bfs(int x, int y, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        dist[y][x] = 0;
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            if(x1 == n && y1 == m) return dist[y1][x1];
            for(int i=0;i<4;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if(nx < 0 || ny < 0 || nx>=101 || ny >= 101) continue;
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[y1][x1] + 1;
                    q.offer(new int[]{nx, ny});
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
