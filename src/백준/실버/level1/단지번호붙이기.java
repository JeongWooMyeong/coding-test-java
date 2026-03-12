package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 단지번호붙이기 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;

    static ArrayList<Integer> cntlist = new ArrayList<>();

    static int[] dx = {-1,1,0,0};   //상하좌우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        //배열 초기화
        arr = new int[n][n];
        visited = new boolean[n][n];
        //입력
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        //돌면서 dfs 수행 및 단지 영역 count
        int count = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
//                if(arr[i][j] == 1 && !visited[i][j]) {
//                    count2 = dfs(i, j);
//                    count += 1;
//                    //System.out.println(count2);
//                    cntlist.add(count2);
//                }

                if(arr[i][j] == 1 && !visited[i][j]) {
                    count2 = bfs(i, j);
                    count += 1;

                    cntlist.add(count2);
                }
            }
        }

        //집의 수 오름차순 정렬
        Collections.sort(cntlist);

        System.out.println(count);
        for(int k : cntlist){
            System.out.println(k);
        }

    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int count = 1;
        for(int i=0;i<4;i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if(curX < 0 || curY < 0 || curX >= n || curY >= n) continue;

            if(!visited[curX][curY] && arr[curX][curY] == 1){
                visited[curX][curY] = true;
                count += dfs(curX, curY);
            }

        }

        return count;
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0;i<4;i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    count += 1;
                }
            }

        }

        return count;
    }

}
