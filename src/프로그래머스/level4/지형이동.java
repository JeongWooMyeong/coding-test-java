package 프로그래머스.level4;

import java.util.*;
import java.io.*;

/*
일단 내생각으로 한번 풀어보자
bfs + 이진탐색
X -> 안됌
모든칸을 방문하기 위해 필요한 사다리 설치 비용 최솟값 - MST
 */

public class 지형이동 {
    static int n,m;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] land, int height){
        int left = 0;
        int right = Integer.MIN_VALUE;
        n = land.length;
        m = land[0].length;
        int answer = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                right = Math.max(right, land[i][j]);
            }
        }

        while(left <= right){
            int mid = (left + right) / 2;

            if(bfs(0,0,n-1,m-1,mid,height,land)){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }


        return answer;
    }

    static boolean bfs(int startX, int startY, int endX, int endY, int target, int height, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        visited = new boolean[n][m];
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if(startX == endX && startY == endY && dist == target) return true;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(Math.abs(land[nx][ny] - land[x][y]) > height){
                    q.offer(new int[]{nx,ny, dist + Math.abs(land[nx][ny] - land[x][y])});
                }else{
                    q.offer(new int[]{nx,ny, dist});
                }


            }

        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        int[][] land = {{1,4,8,10},{5,5,5,5},{10,10,10,10},{10,10,10,20}};
        int height = 3;

        System.out.println(solution(land, height));
    }

}
