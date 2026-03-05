package 백준.골드.level5;

import java.util.*;

public class 탑 {
    static int n;
    static int[] arr;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] results;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        results = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            stack.push(arr[i]);
        }

        while(!stack.isEmpty()){
            int a = stack.pop();
            int b = 0;
            for(int i=0;i<stack.size();i++){
                if(arr[i] > a){
                    b = i + 1;
                }
            }
            results[stack.size()] = b;
        }

        for(int i: results){
            System.out.print(i + " ");
        }

    }

}
