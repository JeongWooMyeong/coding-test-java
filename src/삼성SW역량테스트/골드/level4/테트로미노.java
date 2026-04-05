package 삼성SW역량테스트.골드.level4;

import java.util.*;
import java.io.*;

public class 테트로미노 {
    static int N, M;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                checkExtraShape(i, j);
            }
        }

        System.out.print(max);

    }

    static void dfs(int x, int y, int sum, int depth){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx>=N || ny>=M) continue;
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }
    //ㅗ 모양 예외 처리 dfs이동에서는 이모양이 나올 수 없음
    static void checkExtraShape(int x ,int y){
        int center = map[x][y];
        for(int d = 0;d<4;d++){
            int sum = center;
            boolean valid = true;
            for(int k=0;k<4;k++){
                if(d==k) continue;
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >=N || ny >=M){
                    valid =false;
                    break;
                }
                sum += map[nx][ny];
            }
            if(valid) max = Math.max(max, sum);
        }

    }

}
