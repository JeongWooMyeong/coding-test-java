package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 뱀9 {

    static int N,K,L;
    static Queue<int[]> snake;
    static int[][] map;
    static Map<Integer, String> dirs;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        dirs = new HashMap<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 2;
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String direc = st.nextToken();

            dirs.put(sec, direc);
        }

        System.out.println(simulate());

    }

    static int simulate(){
        snake = new LinkedList<>();
        snake.add(new int[]{1,1});
        int x = 1;
        int y = 1;
        int dir = 1;
        int time = 0;

        map[x][y] = 1;

        while(true){
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 1 || ny < 1 || nx > N || ny > N) break;

            if(map[nx][ny] != 2){
                int[] tail = snake.poll();
                map[tail[0]][tail[1]] = 0;
            }

            if(map[nx][ny] == 1) break;

            snake.offer(new int[]{nx,ny});
            map[nx][ny] = 1;

            if(dirs.containsKey(time)){
                String d = dirs.get(time);
                if("L".equals(d)){
                    dir = (dir + 3) % 4;
                }else{
                    dir = (dir + 1) % 4;
                }
            }

            x = nx;
            y = ny;

        }

        return time;
    }

}
