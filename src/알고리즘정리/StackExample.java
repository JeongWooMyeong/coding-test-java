package 알고리즘정리;

/*
괄호 검증 문제 (올바른 괄호, 괄호 짝 맞추기)
후위 표기식 계산 (스택을 이용한 수식 계산)
DFS 구현 (재귀 대신 스택 사용)

 */
import java.util.*;

public class StackExample {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        //push
        stack.push(10);
        stack.push(20);
        stack.push(30);

        //peek
        System.out.println("Top element: " + stack.peek()); //30

        //pop
        System.out.println("Pop: " + stack.pop());  //30
        System.out.println("Pop: " + stack.pop());  //20

        //empty check
        System.out.println("Is Empty? " + stack.isEmpty()); //false

    }
}
