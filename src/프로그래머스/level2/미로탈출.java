package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 미로탈출 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int answer = 0;
    static int n, m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(String[] maps){
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        //visited = new boolean[n][n];
        //dist = new int[n][n];

        int startX = 0;
        int startY = 0;
        int LX = 0;
        int LY = 0;
        int endX = 0;
        int endY = 0;
        //이차원 map으로 변경
        for(int i=0;i<n;i++){
            String m2 = maps[i];
            for(int j=0;j<m;j++){
                char c = m2.charAt(j);
                if(c == 'S') {
                    startX = i;
                    startY = j;
                   map[i][j] = 1;
                }else if(c == 'X'){
                    map[i][j] = 0;
                }else if(c == 'L'){
                    LX = i;
                    LY = j;
                    map[i][j] = 1;
                }else if(c == 'E'){
                    endX = i;
                    endY = j;
                    map[i][j] = 1;
                }else{
                    map[i][j] = 1;
                }
            }
        }

        //시작점부터 레버까지
        int toL = bfs(startX, startY, LX, LY);
        //만약 레버까지 가지 못한다면
        if(toL == -1) return -1;

        answer = toL;
        //레버부터 도착점 까지
        int toE = bfs(LX, LY, endX, endY);

        if(toE == -1) return -1;

        answer += toE;

        return answer;




    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited = new boolean[n][m];
        dist = new int[n][m];
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

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
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
//        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(solution(maps));
    }

}
