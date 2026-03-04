package 백준.실버.level2;

import java.util.*;

public class 스택수열 {
    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0;i<8;i++){
            int input = sc.nextInt();
            int cnt = 0;
            while(cnt == input){
                System.out.println("+");
                stack.push(i);
                cnt++;
            }

            while(stack.peek() >= input){
                System.out.println("-");
                stack.pop();
            }

        }

        if(!stack.isEmpty()){
            System.out.println("NO");
        }


    }
}
