package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 실패율 {

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
        Arrays.sort(stages);

        int all = stages.length;
        for(int i=1;i<=N;i++){
            int count = upperbound(i, stages) - lowerbound(i, stages);
            double rate = 1;
            if(count == 0){
                rate = 0;
            }else {
                rate = (double) count / all;
            }

            //System.out.println(count);

            all -= count;

            resultList.add(new Stage(i, rate));

        }

        Collections.sort(resultList);

        int[] answer = new int[resultList.size()];

        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i).num;
        }


        return answer;

    }

    static int lowerbound(int target, int[] stages){
        int left = 0;
        int right = stages.length;

        while(left < right){
            int mid = (left + right) / 2;

            if(stages[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        return left;
    }

    static int upperbound(int target, int[] stages){
        int left = 0;
        int right = stages.length;

        while(left < right){
            int mid = (left + right) / 2;

            if(stages[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        return left;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(solution(N, stages)));
    }

}
