package 프로그래머스.level2;

import java.util.Stack;

public class 큰수만들기4 {
    public static String solution(String number, int k){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        char[] c = number.toCharArray();

        int count = 0;
        for(int i=0;i<c.length;i++){
            while(!stack.isEmpty() && k > 0 && stack.peek() < c[i]){
                stack.pop();
                k--;
            }
            stack.push(c[i]);
        }

        while(k>0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
//        for(char ca : stack){
//            sb.append(ca);
//        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception{
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }
}
