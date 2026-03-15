package 백준.골드.level3;

import java.util.*;

public class 감시 {
    static int n, m;
    static int[][] office;
    static List<CCTV> cctvs = new ArrayList<>();
    static int minBlind = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class CCTV{
        int x, y, type;
        CCTV(int x, int y, int type){
            this.x = x; this.y = y; this.type = type;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        office = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                office[i][j] = sc.nextInt();
                if(office[i][j] >= 1 && office[i][j] <= 5){
                    cctvs.add(new CCTV(i, j, office[i][j]));
                }
            }
        }
        dfs(0, office);
        System.out.println(minBlind);
    }

    static void dfs(int idx, int[][] map){
        if(idx == cctvs.size()){
            minBlind = Math.min(minBlind, countBlind(map));
            return;
        }

        CCTV c = cctvs.get(idx);
        int[][] dirs = getDirections(c.type);

        for(int[] dirSet : dirs){
            int[][] copy = copyMap(map);
            for(int d : dirSet) watch(copy, c.x, c.y, d);
            dfs(idx + 1, copy);
        }
    }

    static void watch(int[][] map, int x, int y, int dir){
        int nx = x, ny = y;
        while(true){
            nx += dx[dir]; ny += dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6) break;
            if(map[nx][ny] == 0) map[nx][ny] = -1;  //감시 표시
        }
    }

    static int[][] getDirections(int type){
        switch(type){
            case 1 : return new int[][]{{0}, {1}, {2}, {3}};
            case 2 : return new int[][]{{0, 2}, {1, 3}};
            case 3 : return new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}};
            case 4 : return new int[][]{{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}};
            case 5 : return new int[][]{{0, 1, 2, 3}};
        }

        return new int[0][];
    }

    static int[][] copyMap(int[][] map){
        int[][] newMap = new int[n][m];
        for(int i=0;i<n;i++) newMap[i] = map[i].clone();
        return newMap;
    }

    static int countBlind(int[][] map){
        int cnt = 0;
        for(int[] row : map)
            for(int val : row)
                if(val == 0) cnt++;
        return cnt;
    }

}
