package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기둥과보설치11 {

    static List<int[]> edges;
    static int[][] answer;

    public static int[][] solution(int n, int[][] build_frame){
        edges = new ArrayList<>();

        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];

            if(b == 1){
                edges.add(new int[]{x,y,a});

                if(!check()){
                    edges.remove(edges.size()-1);
                }

            }else{
                int[] target = new int[]{x,y,a};

                edges.removeIf(a1->Arrays.equals(a1,target));

                if(!check()){
                    edges.add(target);
                }

            }

        }

        edges.sort((a1,b1)->{
            if(a1[0] != b1[0]) return a1[0] - b1[0];
            if(a1[1] != b1[1]) return a1[1] - b1[1];

            return a1[2] - b1[2];
        });


        answer= new int[edges.size()][3];

        for(int i=0;i<edges.size();i++){
            answer[i] = edges.get(i);
        }

        return answer;

    }

    static boolean check(){

        for(int i=0;i<edges.size();i++){
            int[] cur = edges.get(i);
            int x = cur[0];
            int y = cur[1];
            int a = cur[2];
            //기둥일때
            if(a == 0){
                if(y == 0 || contains(x,y,1) || contains(x-1,y,1) || contains(x,y-1,0)) continue;

                return false;
            }else{

                if(contains(x,y-1,0) || contains(x+1,y-1,0) || (contains(x-1,y,1) && contains(x+1,y,1))) continue;

                return false;

            }

        }

        return true;
    }

    static boolean contains(int x, int y, int a){
        for(int i=0;i<edges.size();i++){
            int[] cur = edges.get(i);
            if(x == cur[0] && y == cur[1] && a == cur[2]) return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] build_frame = 	{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        System.out.println(Arrays.deepToString(solution(n, build_frame)));
    }

}
