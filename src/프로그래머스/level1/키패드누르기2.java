package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 키패드누르기2 {

    public static String solution(int[] numbers, String hand){

        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0,0});
        map.put(2, new int[]{0,1});
        map.put(3, new int[]{0,2});
        map.put(4, new int[]{1,0});
        map.put(5, new int[]{1,1});
        map.put(6, new int[]{1,2});
        map.put(7, new int[]{2,0});
        map.put(8, new int[]{2,1});
        map.put(9, new int[]{2,2});
        map.put(0, new int[]{3,1});

        int[] left = {3,0};
        int[] right = {3,2};

        StringBuilder sb = new StringBuilder();

        for(int num : numbers){
            int[] point = map.get(num);

            if(num == 1 || num == 4 || num == 7){
                left = point;
                sb.append("L");
            }else if(num == 3 || num == 6 || num == 9){
                right = point;
                sb.append("R");
            }else if(num == 2 || num == 5 || num == 8 || num == 0){
                //맨해튼 거리로도 충분 (난 bfs 씀...)
                int distL = Math.abs(left[0] - point[0]) + Math.abs(left[1] - point[1]);
                int distR = Math.abs(right[0] - point[0]) + Math.abs(right[1] - point[1]);

                if(distL < distR){
                    left = point;
                    sb.append("L");
                }else if(distL > distR){
                    right = point;
                    sb.append("R");
                }else{
                    if(hand.equals("right")){
                        right = point;
                        sb.append("R");
                    }else{
                        left = point;
                        sb.append("L");
                    }
                }
            }

        }

        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        System.out.println(solution(numbers, hand));
    }

}
