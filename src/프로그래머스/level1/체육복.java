package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 체육복 {
    static int[] clothes;

    public static int solution(int n, int[] lost, int[] reserve){
        int answer = 0;
        clothes = new int[n];
        Arrays.fill(clothes, 1);    //clothes 개수 1로 초기화

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //겹치는 부분 (lost, reserve에 둘다 있는 경우 제거)
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for(int l : lost){
            lostList.add(l-1);
        }

        for(int r : reserve){
            reserveList.add(r-1);
        }

        Iterator<Integer> it = lostList.iterator();
        while(it.hasNext()){
            int l = it.next();
            if(reserveList.contains(l)){
                it.remove();
                reserveList.remove(Integer.valueOf(l));
            }
        }

        //lost 인건 clothes -1
        for(int i=0;i<lostList.size();i++){
            clothes[lostList.get(i)] -= 1;
        }
        //reserve인건 여분이니 clothes + 1
        for(int i=0;i<reserveList.size();i++){
            clothes[reserveList.get(i)] += 1;
        }

        //cltohes 돌리면서 0인건 앞이나 뒤에서 빌릴 수 있는지 확인
        for(int i=0;i<clothes.length;i++){
            if(clothes[i] == 0){
                if(i == 0){
                    if(clothes[i+1] > 1){
                        clothes[i+1] -= 1;
                        clothes[i] += 1;
                    }
                }else if(i == clothes.length - 1){
                    if(clothes[i-1] > 1){
                        clothes[i-1] -= 1;
                        clothes[i] += 1;
                    }
                }else{
                    if(clothes[i+1] > 1){
                        clothes[i+1] -= 1;
                        clothes[i] += 1;
                    } else if(clothes[i-1] > 1){
                        clothes[i-1] -= 1;
                        clothes[i] += 1;
                    }
                }
            }
        }

        //마지막으로 clothes 1이상인거 카운트 세기
        for(int i=0;i<clothes.length;i++){
            if(clothes[i] >= 1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] lost = {2};
        int[] reserve = {2};
        int n = 5;

        System.out.println(solution(n,lost,reserve));
    }
}
