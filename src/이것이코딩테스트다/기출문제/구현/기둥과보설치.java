package 이것이코딩테스트다.기출문제.구현;

import java.util.*;

class Node2 implements Comparable<Node2>{
    private int x;
    private int y;
    private int stuff;

    public Node2(int x, int y, int stuff){
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getStuff(){
        return this.stuff;
    }

    //정렬 기준 설정 (x,y,stuff 순서대로 오름 차순)
    @Override
    public int compareTo(Node2 other){
        if(this.x == other.x && this.y == other.y){
            return Integer.compare(this.stuff, other.stuff);
        }
        if(this.x == other.x){
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}


public class 기둥과보설치 {
    //현재 설치된 구조물이 '가능한' 구조물인지 확인하는 함수
    public boolean possible(ArrayList<ArrayList<Integer>> answer){
        for(int i=0;i<answer.size();i++){
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);
            if(stuff == 0){
                //설치된 것이 기둥인 경우
                boolean check = false;
                //바닥우 라면 정상
                if(y==0) check = true;
                //보의 한쪽 끝 부분 위 혹은 다른 기둥 위 라면 정상
                for(int j=0;j<answer.size();j++){
                    if(x-1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                        check = true;
                    }
                    if(x== answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                        check = true;
                    }
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)){
                        check = true;
                    }

                }
                if(!check) return false;
            }else if(stuff == 1){
                //설치된 것이 보인 경우
                boolean check = false;
                boolean left = false;
                boolean right = false;

                //한쪽 끝부분이 기둥 위 혹은 양쪽 끝부분이 다른 보와 동시에 연결 이라면 정상
                for(int j=0;j<answer.size();j++){
                    if(x==answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)){
                        check = true;
                    }
                    if(x +1 == answer.get(j).get(0) && y-1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)){
                        check = true;
                    }
                    if(x-1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                        left = true;
                    }
                    if(x+1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                        right = true;
                    }
                }
                if(left&&right) check = true;
                if(!check) return false; //아니라면 거짓 반환

            }
        }
        return true;
    }
    public int[][] solution(int n, int[][] build_frame){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        //작업의 개수는 최대 1000개
        for(int i=0;i<build_frame.length;i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operate = build_frame[i][3];
            if(operate == 0){
                //일단 삭제를 해본 뒤에
                int index = 0;
                for(int j=0;j<answer.size();j++){
                    if(x==answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2)){
                        index = j;
                    }
                }
                ArrayList<Integer> erased = answer.get(index);
                answer.remove(index);
                if(!possible(answer)){ // 가능한 구조물인지 확인
                    answer.remove(answer.size() -1);    //가능한 구조물이 아니라면 제거
                }
            }
        }

        ArrayList<Node2> ans = new ArrayList<Node2>();
        for(int i=0;i<answer.size();i++){
            ans.add(new Node2(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
        }

        Collections.sort(ans);

        //배열로 바꾸어 반환
        int[][] res = new int[ans.size()][3];
        for(int i=0;i<ans.size();i++){
            res[i][0] = ans.get(i).getX();
            res[i][1] = ans.get(i).getY();
            res[i][2] = ans.get(i).getStuff();
        }

        return res;

    }

}
