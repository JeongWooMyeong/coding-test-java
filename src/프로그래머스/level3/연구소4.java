package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연구소4 {

    static int N,M;
    static List<int[]> virus;
    static List<int[]> empty;
    static int[][] map;
    static boolean[] visited;
    static boolean[][] visited2;
    static int answer;
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
        answer=  Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    empty.add(new int[]{i,j});
                }else if(map[i][j] == 2){
                    virus.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[empty.size()];
        dfs(0);

        System.out.println(answer);

    }

    static void dfs(int idx){

        if(idx == 3){
            answer = Math.max(answer, bfs());
            return;
        }

        for(int i=0;i<empty.size();i++){
            if(!visited[i]){
                int[] arr = empty.get(i);
                visited[i] = true;
                map[arr[0]][arr[1]] = 1;
                dfs(idx+1);
                visited[i] = false;
                map[arr[0]][arr[1]] = 0;
            }
        }

    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited2 = new boolean[N][M];
        int[][] temp = new int[N][M];
        for(int i=0;i<N;i++){
            temp[i] = map[i].clone();
        }
        for(int i=0;i<virus.size();i++){
            int[] aa = virus.get(i);
            q.offer(new int[]{aa[0], aa[1]});
            visited2[aa[0]][aa[1]] = true;
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
                if(visited2[nx][ny]) continue;

                visited2[nx][ny] = true;
                temp[nx][ny] = 2;
                q.offer(new int[]{nx,ny});

            }

        }

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j] == 0){
                    sum += 1;
                }
            }
        }

        return sum;
    }

}
