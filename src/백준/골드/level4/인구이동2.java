package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 인구이동2 {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while(true){
            visited = new boolean[N][N];
            boolean moved = false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        List<int[]> union = bfs(i, j);
                        if(union.size() > 1){
                            moved =true;
                            int sum = 0;
                            for(int[] pos : union){
                                sum += arr[pos[0]][pos[1]];
                            }
                            int avg = sum / union.size();
                            for(int[] pos : union){
                                arr[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }

            if(!moved) break;
            days++;
        }
        System.out.println(days);
    }

    static List<int[]> bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ax = cur[0];
            int ay = cur[1];
            for(int i=0;i<4;i++){
                int nx = ax + dx[i];
                int ny = ay + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                int sub = Math.abs(arr[ax][ay] - arr[nx][ny]);
                if(sub >= L && sub <= R){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    list.add(new int[]{nx, ny});
                }

            }
        }
        return list;
    }

}
