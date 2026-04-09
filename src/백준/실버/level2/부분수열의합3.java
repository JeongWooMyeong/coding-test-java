package 백준.실버.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
DFS 돌렸을때 아무것도 선택안되었을떼 합이 0 나올 수 있으므로
결과값 도출하기전 result 공집합 처리 조건 해주던가
dfs에서 선택된 카운트가 있을때만 카운트 올려주는 조건 추가해줘야함
 */

public class 부분수열의합3 {
    static int N,S;
    static int[] arr;
    static int result = 0;
    //static boolean[] selected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.print(result);


    }

    static void dfs(int idx, int sum, int selectedCount){
        if(idx == N){
            if(selectedCount > 0) {
                if (sum == S) result++;
            }
            return;
        }
        //선택
        dfs(idx+1, sum + arr[idx], selectedCount+1);
        //선택안함
        dfs(idx+1, sum, selectedCount);

    }


}
