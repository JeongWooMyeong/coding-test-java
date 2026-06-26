package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 최소직사각형2 {

    static int longer, shorter;
    static int maxWidth, maxHeight;

    public static int solution(int[][] sizes){
        longer = 0;
        shorter = 0;

        maxWidth = Integer.MIN_VALUE;
        maxHeight = Integer.MIN_VALUE;

        for(int[] s : sizes){
            longer = Math.max(s[0], s[1]);
            shorter = Math.min(s[0], s[1]);

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
