package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 기둥과보설치2 {
    static List<Structure> result = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        int n = 5;
        //int[][] build_frame = 	{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int[][] result = solution(n, build_frame);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<3;j++){
                System.out.print(result[i][j] +" ");
            }
            System.out.print("\n");
        }
    }

    static class Structure implements Comparable<Structure>{
        private int x;
        private int y;
        private int a;

        public Structure(int x, int y, int a){
            this.x = x;
            this.y = y;
            this.a = a;
        }

        public int compareTo(Structure other){
            if(this.x == other.x) {
                if(this.y == other.y) return this.a - other.a;
                return this.y - other.y;
            }
            return this.x - other.x;
        }

    }

    static int[][] solution(int n, int[][] build_frame){

        for(int i=0;i<build_frame.length;i++){
            int x = build_frame[i][0]; //x좌표
            int y = build_frame[i][1]; //y좌표
            //0은 기둥 1은 보
            int a = build_frame[i][2];  //설치 또는 삭제할 구조물 종류
            //1은 설치 0은 삭제
            int b = build_frame[i][3];  //설치 또는 삭제
            //설치 일때
            if(b == 1){
                result.add(new Structure(x, y, a));
                if(!isValid(result)){
                    result.removeIf(s -> s.x == x && s.y == y && s.a == a);   //조건 불만족 -> 복구
                }
            }else{
                //삭제 일때
                result.removeIf(s -> s.x == x && s.y == y && s.a == a);

                if(!isValid(result)){
                    result.add(new Structure(x, y, a));
                }
            }
        }

        Collections.sort(result);

        int[][] answer = new int[result.size()][3];

        for(int i=0;i<result.size();i++){
            answer[i][0] = result.get(i).x;
            answer[i][1] = result.get(i).y;
            answer[i][1] = result.get(i).a;
        }

        return answer;

    }

    static boolean isValid(List<Structure> result){
        for(Structure s : result){
            int x = s.x;
            int y = s.y;
            int a = s.a;
            //a가 기둥 0 보 1일때
            if(a == 0){
                boolean ok = false;

                //바닥 위
                if(y==0) ok = true;
                //다른 기둥위
                for(Structure other : result){
                    if(other.x == x && other.y == y-1 && other.a == 0){
                        ok = true;
                        break;
                    }
                }

                //보의 오른쪽 끝 위
                for(Structure other : result){
                    if(other.x == x-1 && other.y == y && other.a == 1){
                        ok = true;
                        break;
                    }
                }

                //보의 왼쪽 끝위
                for(Structure other : result){
                    if(other.x == x && other.y == y && other.a == 1){
                        ok = true;
                        break;
                    }
                }

                if(!ok) return false;

            }else{
                //보일때
                boolean ok = false;

                //왼쪽 끝에 기둥
                for(Structure other : result){
                    if(other.x == x && other.y == y-1 && other.a == 0){
                        ok = true;
                        break;
                    }
                }

                //기둥 오른쪽 끝에 기눙
                for(Structure other : result){
                    if(other.x == x+1 && other.y == y-1 && other.a == 0){
                        ok = true;
                        break;
                    }
                }

                //양쪽 끝이 보로 연결
                boolean left = false, right = false;
                for(Structure other : result){
                    if(other.x == x-1 && other.y == y && other.a == 1) left = true;
                    if(other.x == x+1 && other.y == y && other.a == 1) right = true;
                }
                if(left && right) ok = true;

                if(!ok) return false;
            }

        }
        return true;
    }
}
