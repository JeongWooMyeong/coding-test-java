package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연구소3 {

    static int N, M;
    static boolean[][] visited;
    static List<int[]> virus;
    static List<int[]> empty;
    static int answer;
    static int[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = Integer.MIN_VALUE;
        virus  = new ArrayList<>();
        empty = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) virus.add(new int[]{i,j});
                if(board[i][j] == 0) empty.add(new int[]{i,j});
            }
        }

        //장애물 설치
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int idx, int count){
        if(count == 3){
            answer = Math.max(answer, simulate());
            return;
        }

        if(idx == empty.size()) return;

        int[] e = empty.get(idx);
        board[e[0]][e[1]] = 1;
        dfs(idx+1, count+1);
        board[e[0]][e[1]] = 0;

        dfs(idx+1, count);
    }

    static int simulate(){
        Queue<int[]> q = new LinkedList<>();
        int[][] temp = new int[N][M];
        int count = 0;

        for(int i=0;i<N;i++){
            temp[i] = board[i].clone();
        }

        for(int i=0;i<virus.size();i++){
            int[] v = virus.get(i);
            q.offer(new int[]{v[0],v[1]});
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(temp[nx][ny] == 1) continue;

                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }

            }

        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }

}
