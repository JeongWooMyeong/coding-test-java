package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기3 {
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int answer = 0;
        int[][] board = new int[102][102];
        visited = new boolean[102][102];
        dist = new int[102][102];
        //사각형 각각 내부 1로 채움 (두배로 하는 이유는 좌표랑 다르게 배열은 대각선이 칸으로 되므로)
        for(int[] rec : rectangle){
            int startX = rec[0];
            int startY = rec[1];
            int endX = rec[2];
            int endY = rec[3];

            for(int i=startY*2;i<=endY*2;i++){
                for(int j=startX*2;j<=endX*2;j++){
                    board[i][j] = 1;
                }
            }

        }

        //테두리만 가능해서 내부는 0으로 다시 채움
        for(int[] rec : rectangle){
            int startX = rec[0];
            int startY = rec[1];
            int endX = rec[2];
            int endY = rec[3];

            for(int i=startY*2+1;i<endY*2;i++){
                for(int j=startX*2+1;j<endX*2;j++){
                    board[i][j] = 0;
                }
            }

        }

        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2, board);
        //2배로 확장했으니 /2
        return answer / 2;
    }

    static int bfs(int startX, int startY, int endX, int endY, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
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

                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if(visited[ny][nx]) continue;

                if(board[ny][nx] == 1){
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[y][x] + 1;
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
