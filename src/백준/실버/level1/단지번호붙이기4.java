package 백준.실버.level1;

import java.io.*;
import java.util.*;
/*
bfs
 */

public class 단지번호붙이기4 {
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
                    count1 = bfs(i,j);
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

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];

            for(int i=0;i<4;i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    cnt++;
                }

            }

        }
        return cnt;
    }



}
