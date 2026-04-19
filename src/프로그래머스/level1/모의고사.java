package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 모의고사 {
    public static int[] solution(int[] answers){
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        int max = Integer.MIN_VALUE;

        List<int[]> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        List<Integer> cntlist = new ArrayList<>();

        for(int i=0;i<list.size();i++) {
            int cnt = 0;
            int[] arr = list.get(i);
            for (int j = 0; j < answers.length; j++) {
                if(arr[j % arr.length] == answers[j]){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            cntlist.add(cnt);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<cntlist.size();i++){
            if(cntlist.get(i) == max){
                answer.add(i+1);
            }
        }

//        int[] result = new int[answer.size()];
//        for(int i=0;i<answer.size();i++){
//            result[i] = answer.get(i);
//        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) throws Exception{
        int[] answers = {1,3,2,4,2};
//        int[] result  = solution(answers);
//        for(int x : result){
//            System.out.println(x);
//        }
        System.out.println(Arrays.toString(solution(answers)));
    }
}
