package 백준.실버.level2;

import java.util.*;

public class 스택수열2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;    //다음에 push할 숫자
        for(int i=0;i<n;i++){
            int target = arr[i];

            //target까지 push
            while(num <= target){
                stack.push(num++);
                sb.append("+\n");
            }

            //스택 top 확인
            if(stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            }else{
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());

    }
}
