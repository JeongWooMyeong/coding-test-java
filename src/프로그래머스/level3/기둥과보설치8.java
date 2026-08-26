package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기둥과보설치8 {

    static List<int[]> result;
    static int[][] answer;

    public static int[][] solution(int n, int[][] build_frame){
        result = new ArrayList<>();

        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int cmd = build[3];

            if(cmd == 1){
                result.add(new int[]{x,y,type});
                if(!can()){
                    result.remove(result.size()-1);
                }

            }else{
                int[] target = new int[]{x,y,type};
                result.removeIf(arr -> Arrays.equals(arr, target));

                if(!can()){
                    result.add(target);
                }

            }

        }

        result.sort((a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];

            return a[2] - b[2];

        });

        answer = new int[result.size()][3];

        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    static boolean can(){

        for(int[] r : result){
            int x = r[0];
            int y = r[1];
            int type = r[2];

            if(type == 0){
                if(y == 0 || contains(x,y,1) || contains(x-1,y,1) || contains(x,y-1,0)) continue;

                return false;

            }else{
                if(contains(x,y-1,0) || contains(x+1,y-1,0) || (contains(x-1,y,1) && contains(x+1,y,1))) continue;

                return false;

            }

        }

        return true;
    }

    static boolean contains(int x, int y, int type){
        for(int[] r : result){
            if(r[0] == x && r[1] == y && r[2] == type) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] build_frame = 	{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        System.out.println(Arrays.deepToString(solution(n, build_frame)));
    }

}
