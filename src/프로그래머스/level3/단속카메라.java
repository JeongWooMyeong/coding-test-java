package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단속카메라 {
    public static int solution(int[][] routes){
        int answer = 0;
        //진입시점 기준으로 오름차순 정렬 (X)
        //진출시점으로 해야합니다..
        Arrays.sort(routes, (a,b)->a[1] - b[1]);
        int camera = -30000;

        for(int[] route : routes){
            //진입시점이 카메라 위치보다 크면 카메라 필요
            if(route[0] > camera){
                answer++;
                //카메라는 진출시점에 설치하는게 최적 (무조건 보므로 여기 설치하면)
                camera = route[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(routes));
    }
}
