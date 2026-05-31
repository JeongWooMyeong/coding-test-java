package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미로탈출명령어2 {
    static int n1,m1;
    static int endX, endY;

    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] direc = {'d','l','r','u'};

    public static String solution(int n, int m, int x, int y, int r, int c, int k){
        x--;
        y--;
        r--;
        c--;

        n1 = n;
        m1 = m;
        endX = r;
        endY = c;

        int dist = Math.abs(x - r) + Math.abs(y - c);
        
        //최소 거리보다 이동 횟수가 부족
        if(dist > k){
            return "impossible";
        }
        
        //남는 이동 횟수가 홀수면 불가능
        if((k-dist) % 2 != 0){
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();

        int curX = x;
        int curY = y;

        for(int step=0;step<k;step++){
            for(int d=0;d<4;d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                int remainMove = k - step - 1;

                int remainDist = Math.abs(nx - endX) + Math.abs(ny - endY);

                //이 방향으로 가도 도착 가능한가?
                if(remainDist > remainMove){
                    continue;
                }

                //남는 이동횟수도 왕복 채울 수 있는가?
                if((remainMove - remainDist) % 2 != 0){
                    continue;
                }

                answer.append(direc[d]);
                curX = nx;
                curY = ny;

                break;
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
