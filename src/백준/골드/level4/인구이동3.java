package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 인구이동3 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    //static ArrayList<int[]> union = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while(true) {

            visited = new boolean[N][N];
            boolean moved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]){
                        List<int[]> list = bfs(i,j);
                        if(list.size() > 1) {
                            moved = true;
                            movePeople(list);
                        }
                    }
                }
            }

            if(!moved) break;
            days++;

        }

        System.out.print(days);


    }

    static List<int[]> bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        q.offer(new int[]{r, c});
        union.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                int people = Math.abs(map[x][y] - map[nx][ny]);
                if(people >= L && people <= R){
                    //조건시에만 충족
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    union.add(new int[]{nx,ny});
                }

            }

        }
        return union;
    }

    static void movePeople(List<int[]> union){
        int sum = 0;
        for(int i=0;i<union.size();i++){
            int[] ss = union.get(i);
            sum += map[ss[0]][ss[1]];
        }
        int result = 0;
        result = sum / union.size();

        for(int i=0;i<union.size();i++){
            int[] ss2 = union.get(i);
            map[ss2[0]][ss2[1]] = result;
        }

    }

}
