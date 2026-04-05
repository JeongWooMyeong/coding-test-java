package 삼성SW역량테스트.골드.level4;

import java.util.*;
import java.io.*;

public class 연구소 {
    static int N, M;
    static List<Virus> virusList = new ArrayList<>();
    static List<int[]> empty = new ArrayList<>();
    static int[][] map;
    static int[][] copy;

    static int max = Integer.MIN_VALUE;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Virus{
        int x, y;
        Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

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
                if(map[i][j] == 2){
                    virusList.add(new Virus(i,j));
                }
                if(map[i][j] == 0){
                    empty.add(new int[]{i,j});
                }

            }
        }
        //바이러스 확산 bfs (문제를 잘못 이해)
        //bfs();
        //일단 벽부터 세워야 함.
        dfs(0,  0);

//        int result = 0;
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                if(map[i][j] == 0){
//                    result++;
//                }
//            }
//        }

        System.out.print(max);

    }

    static void dfs(int start,  int depth){
        if(depth == 3){
            bfs();
            return;
        }
        for(int i=start;i<empty.size();i++){
            int[] e = empty.get(i);
            int x1 = e[0];
            int y1 = e[1];

            map[x1][y1] = 1;
            dfs(i+1, depth + 1);
            map[x1][y1] = 0;

            //dfs(x1+1, y1+1, depth);

        }


    }

    static void bfs(){
        //바이러스가 장애물 세우는 경우에 따라 달리지므로 map을 copy해서 해야함
        copy = new int[N][M];
        for(int i=0;i<N;i++) copy[i] = map[i].clone();

        Queue<Virus> q = new LinkedList<>();
        for(int i=0;i<virusList.size();i++){
            Virus v = virusList.get(i);
            q.offer(new Virus(v.x, v.y));
        }
        //visited 필요없을듯함
        while(!q.isEmpty()){
            Virus virus = q.poll();
            int x = virus.x;
            int y = virus.y;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(copy[nx][ny] == 1) continue;

                if(copy[nx][ny] == 0){
                    copy[nx][ny] = 2;
                    q.offer(new Virus(nx, ny));
                }

            }

        }
        //각 조합마다 카운트 뽑아야 최대값 구함
        count(copy);

    }

    static void count(int[][] copy){
        int safe = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 0){
                    safe++;
                }

            }
        }
        max = Math.max(max, safe);
    }

}
