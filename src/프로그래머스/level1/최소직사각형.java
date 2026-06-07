package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 최소직사각형 {
    static int maxWidth = 0;
    static int maxHeight = 0;

    public static int solution(int[][] sizes){

        for(int[] size: sizes){
            int a = size[0];
            int b = size[1];

            int longer = Math.max(a,b);
            int shorter = Math.min(a,b);

            maxWidth = Math.max(maxWidth, longer);
            maxHeight = Math.max(maxHeight, shorter);

        }

        return maxWidth * maxHeight;


    }

    public static void main(String[] args) throws Exception{
        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
        System.out.println(solution(sizes));
    }

}
