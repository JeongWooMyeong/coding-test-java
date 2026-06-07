package 프로그래머스.level1;

import java.util.*;
import java.io.*;

/*
이거 이진탐색으로 안할 수 있는데 연습겸 이진탐색으로 함
 */

public class 실패율3 {
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

        int total = stages.length;
        for(int i=1;i<=N;i++){
            int count = upperbound(i, stages) - lowerbound(i, stages);
            double rate;
            if(total > 0){
                rate = (double)count / total;
            }else{
                rate = 0;
            }

            total -= count;

            resultList.add(new Stage(i, rate));

        }

        Collections.sort(resultList);

        int[] answer = new int[resultList.size()];
        int idx = 0;
        for(Stage s : resultList){
            answer[idx++] = s.num;
        }

        return answer;

    }

    static int upperbound(int target, int[] arr){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;

    }

    static int lowerbound(int target, int[] arr){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
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
