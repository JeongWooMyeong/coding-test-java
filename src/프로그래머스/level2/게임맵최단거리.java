package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 게임맵최단거리 {
    static boolean[][] visited;
    static int answer = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] maps){
        visited = new boolean[maps.length][maps[0].length];

        answer = bfs(0,0, maps, visited);


        return answer;
    }

    static int bfs(int x, int y, int[][] maps, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,1});
        //maps[x][y] = 1;
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            int cost = cur[2];
            //먼저 도달한 사람이 최단거리
            if(x1 == maps.length-1 && y1 == maps[0].length-1) return cost;
            for(int i=0;i<4;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                //maps[nx][ny] += cost;
                q.offer(new int[]{nx, ny, cost+1});

            }


        }


        return -1;


    }

    public static void main(String[] args) throws Exception{
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

}
