package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기둥과보설치 {

    static List<int[]> result;

    public static int[][] solution(int n, int[][] build_frame){
        result = new ArrayList<>();

        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int cmd = build[3];
            //설치
            if(cmd == 1){
                result.add(new int[]{x,y,type});
                if(!check()){
                    result.remove(result.size()-1);
                }
            }else{
                int[] target = {x,y,type};
                //삭제
                //removeIf 생소함..
                result.removeIf(arr -> Arrays.equals(arr, target));
                if(!check()){
                    result.add(target);
                }
            }

        }

        result.sort((a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];

            return a[2] - b[2];
        });

        int[][] answer = new int[result.size()][3];

        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    //result에 들어간 기둥과 보가 조건을 충족하는지 확인
    static boolean check(){
        for(int[] arr : result){
            int x = arr[0];
            int y = arr[1];
            int type= arr[2];
            //기둥
            if(type == 0){
                if(y ==0 || contains(x,y-1,0) || contains(x-1,y,1) || contains(x,y,1)){
                    continue;
                }
                return false;
            }else{
                //보
                if(contains(x, y-1, 0) || contains(x+1, y-1, 0) || (contains(x-1,y,1) && contains(x+1,y,1))){
                    continue;
                }
                return false;
            }

        }
        return true;
    }

    static boolean contains(int x, int y, int type){
        for(int[] arr : result){
            if(arr[0] == x && arr[1] == y && arr[2] == type) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] build_frame = 	{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        System.out.println(Arrays.deepToString(solution(n, build_frame)));
    }

}
