package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방문길이4 {

    public static int solution(String dirs){
        int x = 5;
        int y = 5;
        Set<String> path = new HashSet<>();
        char[] c = dirs.toCharArray();

        for(int i=0;i<c.length;i++){
            int nx = x;
            int ny = y;

            if(c[i] == 'L') nx -= 1;
            else if(c[i] == 'U') ny += 1;
            else if(c[i] == 'R') nx += 1;
            else if(c[i] == 'D') ny -= 1;

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            String p = makePath(x,y,nx,ny);

            path.add(p);

            x = nx;
            y = ny;

        }


        return path.size();
    }

    static String makePath(int x, int y, int nx, int ny){
        if(x > nx){
            int temp = x;
            x = nx;
            nx = temp;
        }
        if(y > ny){
            int temp = y;
            y = ny;
            ny = temp;
        }

        return x + "," + y + "->" + nx + "," + ny;

    }

    public static void main(String[] args) throws Exception{
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

}
