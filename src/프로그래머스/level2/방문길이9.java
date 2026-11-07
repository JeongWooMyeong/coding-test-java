package 프로그래머스.level2;


import java.util.*;
import java.io.*;

public class 방문길이9 {

    static Set<String> sets;

    public static int solution(String dirs){
        sets = new HashSet<>();

        int x = 5;
        int y = 5;

        for(int i=0;i<dirs.length();i++){
            char dir = dirs.charAt(i);
            int nx = x;
            int ny = y;

            if(dir == 'U'){
                ny += 1;
            }else if(dir == 'L'){
                nx -= 1;
            }else if(dir == 'R'){
                nx += 1;
            }else{
                ny -= 1;
            }

            if(nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;

            String path = makePath(x,y,nx,ny);

            sets.add(path);

            x = nx;
            y = ny;

        }

        return sets.size();
    }

    static String makePath(int x, int y, int nx, int ny){
        int ax;
        int ay;
        int bx;
        int by;

        if(x > nx || (x == nx && y > ny)){
            ax = nx;
            ay = ny;
            bx = x;
            by = y;
        }else{
            ax = x;
            ay = y;
            bx = nx;
            by = ny;
        }

        return ax + "," + ay + "|" + bx + "," + by;

    }

    public static void main(String[] args) throws Exception{
        String dirs = "ULURRDLLU";

        System.out.println(solution(dirs));
    }

}
