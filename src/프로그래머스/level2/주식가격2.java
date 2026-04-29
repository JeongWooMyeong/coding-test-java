package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주식가격2 {
    public static int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        //인덱스 담을 stack
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<prices.length;i++){
            //if문으로 처리하면 안됌 현재 peek인거 빼고서도 이전게 더 작을수도 있기 때문
            //while문으로 다 처리해함
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        //끝까지 떨어지지 않는 경우에 stack에 남아 있으므로 처리 해줘야함
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
