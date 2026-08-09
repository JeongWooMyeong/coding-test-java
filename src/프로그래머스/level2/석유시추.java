package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 석유시추 {

    static Set<Integer> set;
    static int[][] group;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static Map<Integer, Integer> map;

    public static int solution(int[][] land){
        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        map = new HashMap<>();

        visited = new boolean[n][m];
        int groupid = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j] == 1){
                    int count = bfs(i,j,groupid, land);
                    map.put(groupid, count);
                    groupid++;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int j=0;j<m;j++){
            set = new HashSet<>();
            for(int i=0;i<n;i++){
                if(group[i][j] > 0) {
                    set.add(group[i][j]);
                }
            }

            int sum = 0;
            for(int i : set){
                sum += map.get(i);
            }

            answer = Math.max(answer, sum);

        }


        return answer;

    }

    static int bfs(int sx, int sy, int groupid, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = true;
        int count = 1;
        group[sx][sy] = groupid;
        q.offer(new int[]{sx,sy});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(land[nx][ny] == 1){
                    visited[nx][ny] = true;
                    group[nx][ny] = groupid;
                    count += 1;
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
