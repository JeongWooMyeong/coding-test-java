package 백준.골드.level1;

import java.util.*;
import java.io.*;

public class 부분수열의합 {
    static int N, S;
    static int[] A;
    static int[] B;
    static long result = 0;

    static List<Integer> sumListA = new ArrayList<>();
    static List<Integer> sumListB = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정수 개수
        S = Integer.parseInt(st.nextToken());

        A = new int[N/2];
        B = new int[N - (N/2)];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<A.length;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<B.length;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, A, 0,sumListA);
        dfs(0,B, 0,sumListB);

        Collections.sort(sumListB);

        for(int x : sumListA){
            int target = S - x;
            int lower = lowerBound(sumListB, target);
            int upper = upperBound(sumListB, target);


            result += upper - lower;

        }

        if(S == 0 ) result--;

        System.out.print(result);


    }

    static void dfs(int idx, int[] arr, int sum, List<Integer> list){
        if(idx == arr.length){
            list.add(sum);
            return;
        }

        dfs(idx +1, arr, sum + arr[idx], list);
        dfs(idx+1, arr, sum, list);

    }

    static int lowerBound(List<Integer> list, int target){
        int left = 0; int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) >= target) right = mid;
            else left = mid + 1;

        }

        return left;
    }

    static int upperBound(List<Integer> list, int target){
        int left = 0; int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) > target) right = mid;
            else left = mid + 1;
        }

        return left;
    }

}
