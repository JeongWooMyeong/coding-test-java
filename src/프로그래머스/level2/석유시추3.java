package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 석유시추3 {

    static int[][] group;
    static int n,m;
    static boolean[][] visited;
    static Map<Integer, Integer> resultMap;
    static int sum;
    static Set<Integer> set;
    static int answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] land){
        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        visited = new boolean[n][m];
        resultMap = new HashMap<>();

        int groupid = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j] > 0){
                    int count = bfs(i,j,land,groupid);
                    //System.out.println(count);
                    resultMap.put(groupid, count);
                    groupid++;
                }
            }
        }

        answer = Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            sum = 0;
            set = new HashSet<>();

            for(int i=0;i<n;i++){
                if(land[i][j] > 0){
                    set.add(group[i][j]);
                }
            }

            for(int x : set){
                sum += resultMap.get(x);
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    static int dfs(int x, int y, int[][] land, int groupid){
        visited[x][y] = true;
        group[x][y] = groupid;
        int count = 1;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <  0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[nx][ny]) continue;

            if(land[nx][ny] > 0) {
                count += dfs(nx, ny, land, groupid);
            }

        }

        return count;
    }

    static int bfs(int sx, int sy, int[][] land, int groupid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        int count = 1;
        visited[sx][sy] = true;
        group[sx][sy] = groupid;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(land[nx][ny] > 0){
                    visited[nx][ny] = true;
                    group[nx][ny] = groupid;
                    count++;
                    q.offer(new int[]{nx,ny});
                }

            }

        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        int[][] land = {{1,0,1,0,1,1},{1,0,1,0,0,0},{1,0,1,0,0,1},{1,0,0,1,0,0},{1,0,0,1,0,1},{1,0,0,0,0,0},{1,1,1,1,1,1}};

        System.out.println(solution(land));
    }

}
