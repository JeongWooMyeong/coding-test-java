package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방문길이3 {
    static int[][] map;
    static Set<String> set;

    public static int solution(String dirs){
        int answer = 0;
        map = new int[11][11];
        set = new HashSet<>();
        char[] arr = dirs.toCharArray();

        int x = 5;
        int y = 5;

        //int nx = x;
        //int ny = y;

        for(int i=0;i<arr.length;i++){

            int nx = x;
            int ny = y;
            //배열 기준 말고 좌표기준으로 그냥 계산
            if(arr[i] == 'U') ny += 1;
            else if(arr[i] == 'R') nx += 1;
            else if(arr[i] == 'D') ny -= 1;
            else if(arr[i] == 'L') nx -= 1;

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;

            set.add(path1);
            set.add(path2);

            x = nx;
            y = ny;


        }

        return set.size() / 2;
    }

    public static void main(String[] args) throws Exception{
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

}
