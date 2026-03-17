package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 미로탐색2 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++){
                arr[i][j] = line.charAt(j-1) - '0';
            }
        }

        bfs(1,1);

        System.out.println(arr[n][m]);
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];

            for(int i=0;i<4;i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx < 0 || ny < 0 || nx > n || ny > m) continue;

                if(arr[nx][ny] == 1 && !visited[nx][ny]){

                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[a][b] + 1;
                    q.offer(new int[]{nx, ny});

                }

            }

        }

    }

}
