package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
내가 혼자 생각해서 짠 코드
 */

public class 인구이동 {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited; //국경일 boolean true(열림) bfs 돌때마다 초기화

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //땅크기
        L = Integer.parseInt(st.nextToken());   //최소 인구차이
        R = Integer.parseInt(st.nextToken());   //최대 인구차이

        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][N];
            int cnt = bfs(arr);
            if(cnt == 0 ) break;
            int sum = 0;
            int size = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visited[i][j] == true){
                        sum += arr[i][j];
                        size++;
                    }
                }
            }

            sum /= size;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++){
                    if(visited[i][j] == true){
                        arr[i][j] = sum;
                    }
                }
            }
            answer++;

        }


        System.out.print(answer);


    }

    static int bfs(int[][] arr){
        Queue<int[]> q = new LinkedList<>();
        //visited = new boolean[N][N];
        int count = 0;
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
                int sub = Math.abs(arr[x][y] - arr[nx][ny]);
                if(sub >= L && sub <= R && !visited[x][y] && !visited[nx][ny]) {
                    visited[x][y] = true;
                    visited[nx][ny] = true;
                    count++;
                    q.offer(new int[]{nx, ny});
                }

            }


        }

        return count;

    }

}
