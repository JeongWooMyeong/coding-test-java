package 백준.골드.level5;

import java.util.*;

public class 탑3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();   //인덱스를 담기위한 stack
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int a = 0;
            //stack은 인덱스를 담는거니 비교할 arr[i]와
            //작은것의 인덱스만 빼낸다. 어떻게 하지?조건을?
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek() + 1;
            }else{
                result[i] = 0;
            }

            stack.push(i);

        }

        for(int i : result){
            System.out.print(i + " ");
        }


    }
}
