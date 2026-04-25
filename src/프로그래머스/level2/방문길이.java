package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방문길이 {
    public static int solution(String dirs){

        //문제에서 -5 ~ 5 배열로 하려면 양수에서 하는게 좋ㅇ므ㅡ로 0~10
        boolean[][][][] visited = new boolean[11][11][11][11];

        int x = 5;
        int y = 5;
        int count = 0;

        for(char c : dirs.toCharArray()){
            int nx = x;
            int ny = y;

            if(c == 'U') ny++;
            else if(c == 'R') nx++;
            else if(c == 'D') ny--;
            else if(c == 'L') nx--;

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            if(!visited[x][y][nx][ny]){
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                count++;
            }

            x = nx;
            y = ny;

        }

        return count;

    }

    public static void main(String[] args) throws Exception{
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

}
