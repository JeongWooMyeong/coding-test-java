package 삼성SW역량테스트.실버.level1;

import java.util.*;
import java.io.*;

public class 연산자끼워넣기 {
    static int N;
    static int[] number;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int plus, minus, multi, div;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());


        int first = number[0];

        dfs(1, first, plus, minus, multi, div, 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int sum, int plus, int minus, int multi, int div, int depth){
        if(depth == N){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        if(plus > 0) dfs(idx+1, sum+number[idx], plus -1, minus, multi, div, depth+1);
        if(minus > 0) dfs(idx+1, sum-number[idx], plus, minus-1, multi, div, depth+1);
        if(multi > 0) dfs(idx+1, sum*number[idx], plus, minus, multi-1, div, depth+1);
        //자바에서 이부분 처리 안해줘도 통과 하지만 완벽하게 하려면 이러게 써주는게 좋음
        //수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다
        if(div > 0){
            //나누기 조건 음수일때
            int next;
            if(sum < 0){
                next = - (Math.abs(sum) / number[idx]); //몫을 양수로
            }else{
                next = sum / number[idx];
            }
            dfs(idx+1, next, plus, minus, multi, div-1, depth+1);
        }
    }

}
