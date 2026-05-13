package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
내가 생각한건 remain을 구해서 제거하는 방식으로 했는데
1개짜리로만 생각해서 올바른 답이 될 수 없음
 */

public class 귤고르기 {
    static int[] aa;
    static Set<Integer> list;

    public static int solution(int k, int[] tangerine){
        Arrays.sort(tangerine);
        int max = tangerine[tangerine.length-1];
        aa = new int[max+1];
        list = new HashSet<>();
        int remain = tangerine.length - k;

        for(int i=0;i<tangerine.length;i++){
            aa[tangerine[i]] += 1;
        }

        for(int i=0;i<tangerine.length;i++){
            if(aa[tangerine[i]] < 2 && remain > 0){
                remain--;
            }else{
                list.add(tangerine[i]);
            }
        }
        //여기 처리가 힘드네..
        if(remain > 0){
            list.remove(list.size()-1);
        }


        return list.size();
    }

    public static void main(String[] args) throws Exception{
        int k = 6;
        int[] tangerine = {1,3,2,5,4,5,2,3};
        System.out.println(solution(k, tangerine));
    }

}
