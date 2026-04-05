package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 감시 {
    static int N,M;
    static List<CCTV> cctvs = new ArrayList<>();
    static int[][] map;

    static int[] dx = {-1,0,1,0};   //상우하좌
    static int[] dy = {0,1,0,-1};

    static int result = Integer.MAX_VALUE;

    static class CCTV{
        int x;
        int y;
        int type;

        public CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }


        public List<int[]> getDirection(){
            List<int[]> dirs = new ArrayList<>();
            switch(type){
                case 1:
                    dirs.add(new int[]{0});//상
                    dirs.add(new int[]{1});//하
                    dirs.add(new int[]{2}); //좌
                    dirs.add(new int[]{3}); //우
                    break;  //빼먹음
                case 2:
                    dirs.add(new int[]{1,3});   //좌우
                    dirs.add(new int[]{0,2});   //상하
                    break;  //빼먹음
                case 3:
                    dirs.add(new int[]{0,1});   //상우
                    dirs.add(new int[]{1,2});   //우하
                    dirs.add(new int[]{2,3});   //하좌
                    dirs.add(new int[]{3,0});   //좌상
                    break;  //빼먹음
                case 4:
                    dirs.add(new int[]{3,0,1}); //좌상우
                    dirs.add(new int[]{0,1,2}); //상우하
                    dirs.add(new int[]{1,2,3}); //우하좌
                    dirs.add(new int[]{2,3,0}); //하좌우
                    break;  //빼먹음
                case 5:
                    dirs.add(new int[]{0,1,2,3});   //상우하좌
                    break;  //빼먹음
            }
            return dirs;
        }

    }

    public static void main(String[] args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        //맵 정보 입력 및 cctv인것들 리스트에 담기
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //벽도 제외시켜야함
                if(map[i][j] != 0 && map[i][j] != 6){
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(result);

    }

    static void dfs(int idx, int[][] map){
        if(idx == cctvs.size()){
            result = Math.min(result, countZero(map));
            return; //s이걸 왜 빼먹지..
        }

        CCTV c = cctvs.get(idx);
        List<int[]> directions = c.getDirection();
        for(int i=0;i<directions.size();i++){
            //기존 맵으로 해버리면 꼬임 (근데 여기서는 copy 필요없음 사실상)
            //이유 : 감시만 표시하는거라 되돌릴 필요가 없음
            int[][] copymap = copyMap(map);
            int[] dir = directions.get(i);
            watch(copymap, c.x, c.y, dir);
            dfs(idx+1, copymap);


        }
    }

    static int countZero(int[][] map){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }

    static int[][] copyMap(int[][] map){
        int[][] newMap = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int value = map[i][j];
                newMap[i][j] = value;
            }
        }

        return newMap;
    }

    static void watch(int[][] map, int x, int y, int[] dirs){
        for(int d : dirs){
            //while문안에 쓰면 계속 초기화됌
            int nx = x;
            int ny = y;
            while(true){
                nx += dx[d];
                ny += dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                if(map[nx][ny] == 6) break;

                if(map[nx][ny] == 0){
                    map[nx][ny] = -1;
                }


            }
        }
    }

}
