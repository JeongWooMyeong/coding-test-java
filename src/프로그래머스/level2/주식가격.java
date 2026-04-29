package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주식가격 {
    public static int[] solution(int[] prices){
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            //while문 (현재 prices[i] 보다 더 작은 값이 있을 수 있으므로)
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        //끝까지 가격 안떨어진 idx 체크
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(prices)));
    }

}
