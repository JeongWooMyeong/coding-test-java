package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방문길이6 {

    static Set<String> path;

    public static int solution(String dirs){

        path = new HashSet<>();

        int x = 5;
        int y = 5;

        for(int i=0;i<dirs.length();i++){
            int nx = x;
            int ny = y;

            char d = dirs.charAt(i);

            if(d == 'U') ny++;
            if(d == 'R') nx++;
            if(d == 'D') ny--;
            if(d == 'L') nx--;

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            String paths = makePath(x,y,nx,ny);

            path.add(paths);

            x = nx;
            y = ny;

        }

        return path.size();


    }

    static String makePath(int x1, int y1, int x2, int y2){
        String path = "";

        if(x1 > x2 || (x1 == x2 && y1 > y2)){
            int temp1 = x1;
            int temp2 = y1;

            x1 = x2;
            y1 = y2;

            x2 = temp1;
            y2 = temp2;

        }

        path = x1 + "," + y1 + "|" + x2 + "," + y2;

        return path;
    }

    public static void main(String[] args) throws Exception{
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

}
