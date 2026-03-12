package 백준.골드.level4;

import java.io.*;
import java.util.*;


public class 테트로미노2 {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
                checkT(i, j);    //T 모양 예외 처리
            }
        }

        System.out.println(max);
    }

    //DFS로 4칸 탐색
    static void dfs(int x, int y, int depth, int sum){
        //테트로미노가 4칸이라..
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }
        for(int d = 0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    //T모양 예외 처리
    static void checkT(int x,int y){
        int[][] cases = {
                {0,0,-1,0,0,-1,0,1},    //ㅗ
                {0,0,1,0,0,-1,0,1}, //ㅜ
                {0,0,-1,0,1,0,0,1}, //ㅏ
                {0,0,-1,0,1,0,0,-1} //ㅓ
        };
        for(int[] c : cases){
            int sum = 0;
            boolean ok = true;
            for(int i=0;i<8;i += 2){
                int nx = x + c[i];
                int ny = y + c[i+1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m){ ok = false;break;}
                sum += board[nx][ny];
            }
            if(ok) max = Math.max(max, sum);
        }
    }
}
