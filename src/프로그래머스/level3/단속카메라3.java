package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단속카메라3 {

    public static int solution(int[][] routes){
        int answer = 0;

        Arrays.sort(routes, (a,b) -> a[1] - b[1]);

        int camera = -30000;
        for(int[] route : routes){
            if(route[0] > camera){
                answer++;
                camera = route[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] routes = {{-20,-15},{-14,5},{-18,-13},{-5,-3}};

        System.out.println(solution(routes));
    }

}
