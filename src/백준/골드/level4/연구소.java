package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 연구소 {
    static int N, M;
    static int[][] map;
    static int maxScore = Integer.MIN_VALUE;
    static List<int[]> virusList = new ArrayList<>();
    static List<int[]> emptyList = new ArrayList<>();

    static boolean[] selected;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

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
                if(map[i][j] == 2) virusList.add(new int[]{i,j});
                if(map[i][j] == 0) emptyList.add(new int[]{i,j});
            }
        }

        selected = new boolean[emptyList.size()];
        //벽세우기 조합
        dfs(0, 0);

        System.out.print(maxScore);




    }

    static void dfs(int idx, int count){
        if(count == 3){
            maxScore = Math.max(maxScore, bfs());
            return;
        }

        if(idx == emptyList.size()) return;


        //현재 벽 세우기
        //selected[idx] = true;
        int[] empty = emptyList.get(idx);
        map[empty[0]][empty[1]] = 1;
        dfs(idx + 1, count + 1);
        map[empty[0]][empty[1]] = 0;
        //selected[idx] = false;

        dfs(idx +1, count);



    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[][] temp = new int[N][M];
        for(int i=0;i<N;i++) temp[i] = map[i].clone();

        for(int i=0;i<virusList.size();i++){
            int[] virus = virusList.get(i);
            q.offer(new int[]{virus[0], virus[1]});
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

        int count = countZero(temp);
        return count;
    }

    static int countZero(int[][] temp){
        int count = 0;
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
