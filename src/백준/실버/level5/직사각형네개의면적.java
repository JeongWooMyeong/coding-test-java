package 백준.실버.level5;

import java.util.*;
import java.io.*;

public class 직사각형네개의면적 {
    static int x1, x2, y1, y2;
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int r=x1;r<x2;r++){
                for(int c=y1;c<y2;c++){
                    arr[r][c] = 1;
                }
            }
        }

        int area = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j] == 1) area += 1;
            }
        }

        System.out.println(area);

    }

}
