package 백준.실버.level1;

import java.util.*;

public class 연산자끼워넣기 {
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        dfs(1, arr[0], plus, minus, mul, div);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int idx, int sum, int plus, int minus, int mul, int div){
        if(idx == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if(plus > 0) dfs(idx+1, sum+arr[idx], plus -1, minus, mul, div);
        if(minus > 0) dfs(idx+1, sum - arr[idx], plus, minus - 1, mul, div);
        if(mul > 0) dfs(idx+1, sum * arr[idx], plus, minus, mul - 1, div);
        if(div > 0) dfs(idx+1, sum / arr[idx], plus, minus, mul, div -1);
    }

}
