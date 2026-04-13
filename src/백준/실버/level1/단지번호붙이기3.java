package 백준.실버.level1;

import java.util.*;
import java.io.*;

/*
dfs
 */

public class 단지번호붙이기3 {
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> cntlist = new ArrayList<>();

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        //맵 정보 입력
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    count1 = dfs(i,j);
                    count2++;
                    cntlist.add(count1);
                }
            }
        }

        System.out.println(count2);

        Collections.sort(cntlist, Comparator.comparingInt(p -> p));
        for(int x : cntlist){
            System.out.println(x);
        }


    }

    static int dfs(int x, int y){
        int count = 1;
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if(!visited[nx][ny] && map[nx][ny] == 1){
                count += dfs(nx, ny);
            }

        }

        return count;
    }


}
