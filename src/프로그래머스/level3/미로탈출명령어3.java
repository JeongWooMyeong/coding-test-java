package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미로탈출명령어3 {

    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] direc = {'d','l','r','u'};

    public static String solution(int n, int m, int x, int y, int r, int c ,int k){
        x--;
        y--;
        r--;
        c--;

        int dist = Math.abs(r-x) + Math.abs(c-y);
        if(dist > k) return "impossible";

        if((k-dist) % 2 != 0) return "impossible";

        StringBuilder answer = new StringBuilder();
        int curX = x;
        int curY = y;
        while(k > 0){
            for(int d=0;d<4;d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int newdist = Math.abs(nx - r) + Math.abs(ny - c);
                int remain = k - 1;

                if(newdist <= remain && (remain - newdist) % 2 == 0){
                    answer.append(direc[d]);
                    curX = nx;
                    curY = ny;
                    k--;
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
