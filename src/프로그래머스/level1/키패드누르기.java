package 프로그래머스.level1;

import java.util.*;
import java.io.*;

/*
이것도 맞지만 너무 과함...

 */

public class 키패드누르기 {
    static int[][] pad = {{1,2,3},{4,5,6},{7,8,9},{-2,0,-1}};
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static String solution(int[] numbers, String hand){
        int[] righthand = new int[2];
        int[] lefthand = new int[2];
        String answer = "";

        righthand = findPoint(-1);
        lefthand = findPoint(-2);

        for(int x : numbers){
            if(x == 1 || x == 4 || x == 7){
                lefthand = findPoint(x);
                answer += "L";
            }else if(x == 3 || x == 6 || x == 9){
                righthand = findPoint(x);
                answer += "R";
            }else if(x == 2 || x == 5 || x == 8 || x== 0){
                int[] endPoint = findPoint(x);
                int distL = bfs(lefthand, endPoint);
                int distR = bfs(righthand, endPoint);

                if(distL == distR){
                    if(hand.equals("right")) {
                        answer += "R";
                        righthand = endPoint;
                    }else{
                        answer += "L";
                        lefthand = endPoint;
                    }
                }else{
                    if(distL < distR){
                        answer += "L";
                        lefthand = endPoint;
                    }else{
                        answer += "R";
                        righthand = endPoint;
                    }
                }

            }
        }

        return answer;

    }

    static int[] findPoint(int x){
        int[] result = new int[2];
        boolean found = false;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(x == pad[i][j]){
                    result[0] = i;
                    result[1] = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        return result;
    }

    static int bfs(int[] hand, int[] end){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[4][3];
        int[][] dist = new int[4][3];
        q.offer(new int[]{hand[0],hand[1]});
        visited[hand[0]][hand[1]] = true;
        dist[hand[0]][hand[1]] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == end[0] && y == end[1]) return dist[x][y];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 4 || ny >= 3) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});

            }

        }

        return -1;

    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        System.out.println(solution(numbers, hand));
    }


}
