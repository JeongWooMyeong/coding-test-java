package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 실패율2 {

    static ArrayList<Stage> resultList;

    static class Stage implements Comparable<Stage>{
        int num;
        double rate;

        public Stage(int num, double rate){
            this.num = num;
            this.rate = rate;
        }

        public int compareTo(Stage other){
            if(this.rate == other.rate){
                return this.num - other.num;
            }

            return Double.compare(other.rate, this.rate);
        }


    }

    public static int[] solution(int N, int[] stages){

        resultList = new ArrayList<>();
        int total = stages.length;
        Arrays.sort(stages);
        int[] answer = new int[N];

        for(int i=1;i<=N;i++){
            int count = 0;
            for(int x : stages){
                if(x == i) count++;
            }

            if(total > 0) {
                double rate = (double)count / total;
                resultList.add(new Stage(i, rate));
            }else{
                resultList.add(new Stage(i, 0));
            }

            total -= count;
        }

        Collections.sort(resultList);

        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i).num;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(solution(N, stages)));
    }

}
