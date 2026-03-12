package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
실패한 코드
 */

public class 토마토 {
    static int m, n;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;

                }
                result = Math.max(result, arr[i][j]);
            }
        }

        System.out.print(result);

    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];

            for(int i=0;i<4;i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (!visited[nx][ny] && arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }

            }

        }
        return count;
    }

}
