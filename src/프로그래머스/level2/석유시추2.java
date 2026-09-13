package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 석유시추2 {

    static boolean[][] visited;
    static int n,m;
    static int[][] group;
    static Map<Integer, Integer> countMap;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] land){
        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        visited = new boolean[n][m];
        countMap = new HashMap<>();

        int groupid = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int count = bfs(i,j,1,land,groupid);
                    countMap.put(groupid, count);
                    groupid++;
                }
            }
        }

        int answer = 0;
        Set<Integer> groupSet;

        for(int j=0;j<m;j++){
            groupSet = new HashSet<>();
            int sum = 0;
            for(int i=0;i<n;i++){
                if(land[i][j] > 0){
                    groupSet.add(group[i][j]);
                }
            }

            for(int x : groupSet){
                sum += countMap.get(x);
            }

            answer = Math.max(answer, sum);
        }


        return answer;
    }

    static int bfs(int sx, int sy, int target, int[][] land, int groupid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        visited[sx][sy] = true;
        group[sx][sy] = groupid;
        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(land[nx][ny] != target) continue;

                visited[nx][ny] = true;
                group[nx][ny] = groupid;
                count += 1;
                q.offer(new int[]{nx,ny});

            }


        }

        return count;

    }

    public static void main(String[] args) throws Exception{
        int[][] land = {{1,0,1,0,1,1},{1,0,1,0,0,0},{1,0,1,0,0,1},{1,0,0,1,0,0},{1,0,0,1,0,1},{1,0,0,0,0,0},{1,1,1,1,1,1}};

        System.out.println(solution(land));
    }


}
