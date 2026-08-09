package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미로탈출명령어6 {

    static StringBuilder answer;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] direc = {'d','l','r','u'};

    public static String solution(int n, int m, int x, int y, int r, int c, int k){
        //0 based
        x--;
        y--;
        r--;
        c--;

        answer = new StringBuilder();

        int minDist = Math.abs(x-r) + Math.abs(y-c);
        if(minDist > k) return "impossible";
        if((k - minDist) % 2 != 0) return "impossible";

        int curX = x;
        int curY = y;

        while(k > 0){
            for(int d=0;d<4;d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int newDist = Math.abs(nx - r) + Math.abs(ny - c);
                int remain = k - 1;

                if(newDist <= remain && (remain - newDist) % 2 == 0){
                    answer.append(direc[d]);
                    k--;
                    curX = nx;
                    curY = ny;
                    break;
                }

            }
        }

        return answer.toString();
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        System.out.println(solution(n,m,x,y,r,c,k));
    }


}
