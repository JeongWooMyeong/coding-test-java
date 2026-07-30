package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방문길이7 {

    static Set<String> answer;

    public static int solution(String dirs){
        answer = new HashSet<>();

        int x = 5;
        int y = 5;

        for(int i=0;i<dirs.length();i++){
            char dir = dirs.charAt(i);

            int nx = x;
            int ny = y;

            if(dir == 'U') ny--;
            if(dir == 'R') nx++;
            if(dir == 'D') ny++;
            if(dir == 'L') nx--;

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            String path = makePath(x,y, nx, ny);

            answer.add(path);

            x = nx;
            y = ny;

        }


        return answer.size();
    }

    static String makePath(int x1, int y1, int x2, int y2){

        int ax, ay, bx, by;
        String result = "";

        if(x1 > x2 || (x1==x2 && y1 > y2)){
            ax = x2;
            ay = y2;
            bx = x1;
            by = y1;
        }else{
            ax = x1;
            ay = y1;
            bx = x2;
            by = y2;
        }

        result = ax + "," + ay + "|" + bx + "," + by;

        return result;

    }

    public static void main(String[] args) throws Exception{
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }

}
