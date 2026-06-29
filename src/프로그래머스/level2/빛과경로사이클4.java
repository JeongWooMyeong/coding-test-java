package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 빛과경로사이클4 {

    static int R,C;
    static ArrayList<Integer> cycles;
    static boolean[][][] visited;
    static int[] answer;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static int[] solution(String[] grid){
        R = grid.length;
        C = grid[0].length();

        cycles = new ArrayList<>();
        visited = new boolean[R][C][4];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                for(int d=0;d<4;d++){
                    if(!visited[r][c][d]){
                        int len = travel(r,c,d,grid);
                        cycles.add(len);
                    }
                }
            }
        }

        Collections.sort(cycles);

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
            if(ch == 'R') d = (d + 1) % 4;
            if(ch == 'L') d = (d + 3) % 4;

            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;

        }

        return len;
    }

    public static void main(String[] args) throws Exception{
        String[] grid = {"SL", "LR"};
        System.out.println(Arrays.toString(solution(grid)));
    }

}
