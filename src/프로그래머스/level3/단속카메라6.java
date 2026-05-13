package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단속카메라6 {

    public static int solution(int[][] routes){
        int answer =0;
        //차량 진출 시점 오름차순 정렬
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        int camera = -30000;

        for(int i=0;i<routes.length;i++){
            if(camera < routes[i][0]){
                answer++;
                camera = routes[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};

        System.out.println(solution(routes));
    }

}
