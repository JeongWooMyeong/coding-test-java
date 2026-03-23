package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 단지번호붙이기2 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int count1 = 0; //전체 개수
        int count2 = 0; // 단지 개수
        List<Integer> cntlist = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
//                if(arr[i][j] == 1 && !visited[i][j]) {
//                    count2 = dfs(i, j);
//                    count1++;
//                    cntlist.add(count2);
//                }

                if(arr[i][j] == 1 && !visited[i][j]) {
                    count2 = bfs(i, j);
                    count1++;
                    cntlist.add(count2);
                }
            }

        }

        Collections.sort(cntlist);
        System.out.println(count1);
        for(int x : cntlist) System.out.println(x);


    }

    static int dfs(int x, int y){
        int count = 1;
        visited[x][y] = true;

        for(int i =0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >=N || ny >= N) continue;

            if(!visited[nx][ny] && arr[nx][ny] == 1){
                visited[nx][ny] = true;
                count += dfs(nx, ny);
            }

        }

        return count;
    }

    static int bfs(int a, int b){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }

                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }

            }

        }
        return cnt;
    }

}
