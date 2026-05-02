package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
계속 bfs로 풀면될거 같은데 이게 아닌가보네..
간선 기준으로 생각을 해야하네..
 */

public class 방문길이2 {
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    public static int solution(String dirs) {
        map = new int[11][11];
        visited = new boolean[11][11];
        char[] arr = dirs.toCharArray();

        bfs(5,5,arr);



        return answer;
    }

    static void bfs(int x, int y, char[] arr){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            for(int i=0;i<arr.length;i++){
                int nx = x1;
                int ny = y1;
                if(arr[i] == 'L'){
                    ny -= 1;
                }else if(arr[i] == 'D'){
                    nx -= 1;
                }else if(arr[i] == 'R'){
                    ny += 1;
                }else if(arr[i] == 'U'){
                    nx += 1;
                }

                if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    visited[ny][nx] = true;
                    answer += 1;
                }


            }


        }
    }

    public static void main(String[] args) throws Exception{
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

}
