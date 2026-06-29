package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 빛과경로사이클3 {

    static int R,C;
    static boolean[][][] visited;
    static List<Integer> cycles;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] answer;

    public static int[] solution(String[] grid){
        R = grid.length;
        C = grid[0].length();

        visited = new boolean[R][C][4];
        cycles = new ArrayList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                for(int d=0;d<4;d++){
                    if(!visited[i][j][d]){
                        int len = travel(i,j,d,grid);
                        cycles.add(len);
                    }
                }
            }
        }


        answer = new int[cycles.size()];
        for(int i=0;i<cycles.size();i++){
            answer[i] = cycles.get(i);
        }

        return answer;
    }

    static int travel(int r, int c, int d, String[] grid){
        int len = 0;

        while(!visited[r][c][d]){
            visited[r][c][d] = true;
            len++;

            char ch = grid[r].charAt(c);
            if(ch == 'L') d = (d + 3) % 4;
            if(ch == 'R') d = (d + 1) % 4;


            r = (r + d + R) % R;
            c = (c + d + C) % C;

        }

        return len;

    }

    public static void main(String[] args) throws Exception{
        String[] grid = {"SL", "LR"};
        System.out.println(Arrays.toString(solution(grid)));
    }

}
