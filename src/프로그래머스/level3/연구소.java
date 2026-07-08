package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연구소 {

    static int N, M;
    static int[][] board;
    static List<int[]> virusList;
    static List<int[]> emptyList;
    static int maxScore;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxScore = Integer.MIN_VALUE;

        virusList = new ArrayList<>();
        emptyList = new ArrayList<>();

        board = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    virusList.add(new int[]{i,j});
                }else if(board[i][j] == 0){
                    emptyList.add(new int[]{i,j});
                }
            }
        }

        dfs(0, 0);

        System.out.println(maxScore);
    }

    static void dfs(int idx, int count){
        if(count == 3){
            maxScore = Math.max(maxScore, bfs());
            return;
        }

        if(idx == emptyList.size()) return;


        //장애물 놓는경우
        int[] empty = emptyList.get(idx);
        board[empty[0]][empty[1]] = 1;
        dfs(idx + 1, count +1);
        board[empty[0]][empty[1]] = 0;

        dfs(idx+1, count);

    }

    static int bfs(){
        int[][] temp = new int[N][M];

        for(int i=0;i<N;i++){
            temp[i] = board[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for(int[] v : virusList){
            q.offer(new int[]{v[0], v[1]});
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny <0 || nx >= N || ny >= M) continue;

                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }

            }

        }

        int count = countZero(temp);

        return count;

    }

    static int countZero(int[][] temp){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j] == 0) count++;
            }
        }

        return count;
    }

}
