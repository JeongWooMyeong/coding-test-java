package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 거리두기확인하기 {
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> pList;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int[] solution(String[][] places){
        int[] answer = new int[places.length];

        int idx = 0;
        for(String[] p : places){
            pList = new ArrayList<>();
            int n = places.length;
            int m = p.length;
            map = new char[n][m];
            //visited = new boolean[n][m];

            for(int i=0;i<p.length;i++) {
                String line = p[i];
                for(int j=0;j<line.length();j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == 'P') pList.add(new int[]{i,j});
                }
            }

            if(pList.isEmpty()){
                answer[idx] = 1;
                idx++;
                continue;
            }

            boolean found = false;
            for(int i=0;i<pList.size();i++){
                for(int j=0;j<pList.size();j++){
                    if(i == j) continue;
                    visited = new boolean[n][m];
                    int[] a = pList.get(i);
                    int[] b = pList.get(j);
                    int dist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                    if(dist <= 2 && bfs(a[0],a[1],b[0],b[1])){
                        answer[idx] = 0;
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }

            if(!found) {
                answer[idx] = 1;
            }
            idx++;

        }

        return answer;
    }

    static boolean bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];
            if(x == endX && y == endY) return true;
            if(depth >= 2) continue;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 'O' || (nx == endX && ny == endY)){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny, depth+1});
                }
            }


        }
        return false;
    }

    public static void main(String[] arsgs) throws Exception{
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }

}
