package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단속카메라4 {
    public static int solution(int[][] routes){
        Arrays.sort(routes, (a,b)->a[1] - b[1]);

        int answer = 0;
        int camera = -30000;    //최소 지점
        //출입지점 기준으로 카메라 세워야 최소 개수를 구할 수 있음
        for(int[] r : routes){
            //여기서는 카메라가 차량 진입보다 작을때지..
            if(camera < r[0]){
                answer++;
                camera = r[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};

        System.out.println(solution(routes));
    }

}
