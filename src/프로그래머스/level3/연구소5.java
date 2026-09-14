package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연구소5 {
    static int N,M;
    static int[][] map;
    static List<int[]> virus;
    static List<int[]> empty;
    static int answer;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virus = new ArrayList<>();
        empty = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i,j});
                }else if(map[i][j] == 0){
                    empty.add(new int[]{i,j});
                }
            }
        }

        answer = 0;


        dfs(0,0);

        System.out.println(answer);



    }

    static void dfs(int start, int count){

        if(count == 3){
            answer = Math.max(answer, bfs());
            return;
        }

        for(int i=start;i<empty.size();i++){
            int[] arr = empty.get(i);
            map[arr[0]][arr[1]] = 1;
            dfs(i+1, count+1);
            map[arr[0]][arr[1]] = 0;
        }

    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];
        int[][] temp = new int[N][M];
        for(int i=0;i<N;i++){
            temp[i] = map[i].clone();
        }

        for(int[] v : virus){
            q.offer(new int[]{v[0],v[1]});
            visited[v[0]][v[1]] = true;
        }
        int count = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(temp[nx][ny] == 1) continue;

                temp[nx][ny] = 2;
                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
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
