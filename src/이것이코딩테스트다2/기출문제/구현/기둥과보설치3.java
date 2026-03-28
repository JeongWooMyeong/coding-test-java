package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 기둥과보설치3 {
    static class Structure implements Comparable<Structure>{
        int x;
        int y;
        int a;  //0은 기둥, 1은 보

        public Structure(int x, int y, int a){
            this.x = x;
            this.y = y;
            this.a = a;
        }

        public int compareTo(Structure other){
            if(this.x == other.x){
                if(this.y == other.y) return this.a - other.a;
                return this.y - other.y;
            }
            return this.x - other.x;
        }


    }

    public int[][] solution(int n, int[][] build_frame) {
        List<Structure> result = new ArrayList<>();

        //build_frame을 돌면서 보, 기둥 설치 확인
        for(int i=0;i<build_frame.length;i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            //설치 일때
            if(b == 1){
                //result에 담는다 일단
                result.add(new Structure(x,y,a));
                //result담은것에 대한 유효성 판별
                if(!isValid(result)){
                    //유효하지 않다면 빼버림
                    // 유효하지 않다면 조건으로 삭제
                    result.removeIf(s -> s.x == x && s.y == y && s.a == a);

                }
            }
            //삭제 일때
            else{
                //일단 삭제
                // 유효하지 않다면 조건으로 삭제
                result.removeIf(s -> s.x == x && s.y == y && s.a == a);

                if(!isValid(result)){
                    //유효하지 않으면 다시 넣어버림
                    result.add(new Structure(x,y,a));
                }
            }

        }

        Collections.sort(result);

        //다 돌고 결과물 리턴
        int[][] answer = new int[result.size()][3];

        for(int i=0;i<result.size();i++){
            Structure str = result.get(i);
            answer[i][0] = str.x;
            answer[i][1] = str.y;
            answer[i][2] = str.a;
        }

        return answer;
    }

    static boolean isValid(List<Structure> result){
        for(Structure s : result){
            int x = s.x;
            int y = s.y;
            int a = s.a;
            //기둥 일때
            if(a == 0){
                boolean ok = false;
                //바닥 위에 있을때
                if(y == 0){
                    ok = true;

                }
                //다른 기둥 위에 있을때
                for(Structure other : result){
                    if(other.x == x && other.y == y-1 && other.a == 0){
                        ok = true;
                        break;
                    }
                }
                //보의 오른쪽 끝부분에 위에 있을떄
                for(Structure other : result){
                    if(other.x == x-1 && other.y == y && other.a == 1){
                        ok = true;
                        break;
                    }
                }

                //보의 왼쪽 끝부분 위에 있을때
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
                //한쪽 끝부분이 기둥 위에 있다.
                for(Structure other : result){
                    if(other.x == x && other.y == y-1 && other.a == 0){
                        ok = true;
                        break;
                    }
                }
                for(Structure other : result){
                    if(other.x == x+1 && other.y == y-1 && other.a == 0){
                        ok = true;
                        break;
                    }
                }
                boolean left = false;
                boolean right = false;
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

