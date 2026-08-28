package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단속카메라15 {

    public static int solution(int[][] routes){
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        int camera = -30000;
        int answer = 0;

        for(int[] r : routes){
            if(camera < r[0]){
                camera = r[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(routes));
    }

}
