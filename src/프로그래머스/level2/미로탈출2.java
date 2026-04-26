package 프로그래머스.level2;

import java.util.*;
import java.io.*;


public class 미로탈출2 {

    static int[][] board;
    static boolean[][] visited;
    static int[][] dist;
    static int startX, startY;  //출발 위치
    static int LX, LY; //레버 위치
    static int endX, endY;  //출구 위치
    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(String[] maps){
        int answer = 0;
        n = maps.length;
        m = maps[0].length();

        board = new int[n][m];

        for(int i=0;i<n;i++){
            String line = maps[i];
            for(int j=0;j<line.length();j++){
                char c = line.charAt(j);
                if(c == 'S'){
                    startX = i;
                    startY = j;
                }else if(c == 'E'){
                    endX = i;
                    endY = j;
                }else if(c == 'L'){
                    LX = i;
                    LY = j;
                }else if(c == 'X'){
                    board[i][j] = 1;
                }
            }
        }

        //1.우선적으로 레버위치까지 가야함
        int toL = bfs(startX, startY, LX, LY);

        if(toL == -1) return -1;

        answer += toL;

        //2. 레버에서 출구위치까지 거리
        int toE = bfs(LX, LY, endX, endY);

        if(toE == -1) return -1;

        answer += toE;




        return answer;
    }

    static int bfs(int startX , int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        dist = new int[n][m];

        q.offer(new int[]{startX, startY});
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
                if(board[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});

            }


        }
        return -1;

    }

    public static void main(String[] args) throws Exception{
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(solution(maps));
    }


}
