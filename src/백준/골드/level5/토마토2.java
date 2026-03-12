package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 토마토2 {
    static int n,m;
    static int[][] arr;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];

            for(int i=0;i<4;i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(arr[nx][ny] == 0){
                    arr[nx][ny] = arr[curx][cury] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, arr[i][j]);
            }
        }
        System.out.println(result-1);


    }

}
