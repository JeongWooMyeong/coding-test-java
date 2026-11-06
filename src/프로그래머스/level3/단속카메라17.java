package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단속카메라17 {

    public static int solution(int[][] routes){
        int camera = -30000;
        int answer = 0;
        Arrays.sort(routes, (a,b)->a[1]-b[1]);

        for(int[] r : routes){
            if(camera < r[0]){
                camera = r[1];
                answer++;
            }
        }

        return answer;
    }

}
