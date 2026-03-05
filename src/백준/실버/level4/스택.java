package 백준.실버.level4;

import java.util.*;

public class 스택 {
    static Stack<Integer> stack = new Stack<>();
    static int n;
    static String command;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //명령어 개수

        for(int i=0;i<n;i++){
            command = sc.next();
            if(command.equals("push")){
                stack.push(sc.nextInt());
            }else if(command.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }else if(command.equals("size")){
                System.out.println(stack.size());
            }else if(command.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(command.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }
        }

    }
}
