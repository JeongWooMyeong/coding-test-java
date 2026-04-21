package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기 {
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){

        for(int [] rec : rectangle){
            for(int y=rec[1]*2;y<=rec[3]*2;y++){
                for(int x=rec[0]*2;x<=rec[2]*2;x++){
                    map[y][x] = 1;
                }
            }
        }
        //내부 처리?
        for(int[] rec : rectangle){
            for(int y=rec[1]*2+1;y<rec[3]*2;y++){
                for(int x=rec[0]*2+1;x<rec[2]*2;x++){
                    map[y][x] = 0;
                }
            }
        }

        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return answer / 2;
    }

    static int bfs(int x, int y, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;
        map[y][x] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n && cur[1] == m) return map[cur[1]][cur[0]];

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101) continue;

                if(!visited[ny][nx] && map[ny][nx] == 1){
                    map[ny][nx] = map[cur[1]][cur[0]] + 1;
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
