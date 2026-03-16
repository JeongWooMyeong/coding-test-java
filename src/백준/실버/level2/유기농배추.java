package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 유기농배추 {
    static int[][] board;
    static int t, m, n, k;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int g=0;g<t;g++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(board[i], 0);
                Arrays.fill(visited[i], false);
            }

            //배추 위치 입력
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[x][y] = 1;

            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(dfs(i, j)){
                        result += 1;
                    }
                }
            }

            System.out.println(result);

        }



    }

    static boolean dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;

        if(board[x][y] == 1 && !visited[x][y]){
            //해당 노드를 방문처리
            visited[x][y] = true;
            //상 하 좌 우의 위치들도 모두 재귀적으로 호출
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }

}
